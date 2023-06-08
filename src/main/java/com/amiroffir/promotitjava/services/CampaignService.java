package com.amiroffir.promotitjava.services;

import com.amiroffir.promotitjava.DTOs.CampaignDTO;
import com.amiroffir.promotitjava.DTOs.UpdateCampaignDTO;
import com.amiroffir.promotitjava.models.Campaign;
import com.amiroffir.promotitjava.models.User;
import com.amiroffir.promotitjava.repos.CampaignRepo;
import com.amiroffir.promotitjava.repos.UserRepo;
import com.amiroffir.promotitjava.services.LogServices.LogService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignService {
    @Autowired
    private CampaignRepo campaignRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private LogService logService;

    public CampaignDTO addCampaign(CampaignDTO campaignDTO) {
        try {
            Campaign newCampaign = modelMapper.map(campaignDTO, Campaign.class);
            Campaign savedCampaign = campaignRepo.save(newCampaign);
            logService.logInfo("Campaign " + savedCampaign.getCampaignName() + " added successfully");
            CampaignDTO savedCampaignDTO = modelMapper.map(savedCampaign, CampaignDTO.class);
            return savedCampaignDTO;
        } catch (Exception e) {
            logService.logError("Failed to add campaign" + e.getMessage());
            throw e;
        }
    }

    public List<CampaignDTO> getCampaigns() {
        try {
            List<Campaign> campaignsList = campaignRepo.findAll();
            List<CampaignDTO> campaignDTOList =
                    campaignsList.stream().map(campaign -> modelMapper.map(campaign, CampaignDTO.class)).toList();
            logService.logInfo(campaignDTOList.size() + " Campaigns retrieved successfully");
            return campaignDTOList;
        } catch (Exception e) {
            logService.logError("Failed to retrieve campaigns" + e.getMessage());
            throw e;
        }
    }

    public CampaignDTO getCampaign(int id) {
        try {
            Campaign campaign = campaignRepo.findById(id).orElse(null);
            CampaignDTO campaignDTO = modelMapper.map(campaign, CampaignDTO.class);
            logService.logInfo("Campaign " + campaignDTO.getCampaignName() + " retrieved successfully");
            return campaignDTO;
        } catch (Exception e) {
            logService.logError("Failed to retrieve campaign" + e.getMessage());
            throw e;
        }
    }

    public List<CampaignDTO> getMyCampaigns(String email) throws Exception {
        try {
            User user = userRepo.findByEmail(email).orElseThrow();
            List<Campaign> campaignsList = campaignRepo.findByNonProfitRep(user);
            List<CampaignDTO> campaignDTOList =
                    campaignsList.stream().map(campaign -> modelMapper.map(campaign, CampaignDTO.class)).toList();
            logService.logInfo(campaignDTOList.size() + " Campaigns retrieved successfully");
            return campaignDTOList;
        } catch (Exception e) {
            logService.logError("Failed to retrieve campaigns" + e.getMessage());
            throw e;
        }
    }

    public CampaignDTO updateCampaign(UpdateCampaignDTO campaign) {
        try {
            Campaign campaignToUpdate = campaignRepo.findById(campaign.getId()).orElseThrow();
            campaignToUpdate.setCampaignName(campaign.getCampaignName());
            campaignToUpdate.setCampaignDesc(campaign.getCampaignDesc());
            campaignToUpdate.setCampaignHash(campaign.getCampaignHash());
            campaignToUpdate.setCampaignUrl(campaign.getCampaignUrl());
            Campaign updatedCampaign = campaignRepo.save(campaignToUpdate);
            CampaignDTO updatedCampaignDTO = modelMapper.map(updatedCampaign, CampaignDTO.class);
            logService.logInfo("Campaign " + updatedCampaignDTO.getCampaignName() + " updated successfully");
            return updatedCampaignDTO;
        } catch (Exception e) {
            logService.logError("Failed to update campaign" + e.getMessage());
            throw e;
        }
    }

    public Boolean deleteCampaign(String id) {
        try {
            campaignRepo.deleteById(Integer.parseInt(id));
            logService.logInfo("Campaign " + id + " deleted successfully");
            return true;
        } catch (Exception e) {
            logService.logError("Failed to delete campaign" + e.getMessage());
            throw e;
        }
    }
}