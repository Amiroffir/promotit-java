package com.amiroffir.promotitjava.controllers;

import com.amiroffir.promotitjava.DTOs.CampaignDTO;
import com.amiroffir.promotitjava.DTOs.UpdateCampaignDTO;
import com.amiroffir.promotitjava.services.CampaignService;
import com.amiroffir.promotitjava.services.LogServices.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class CampaignController {
    @Autowired
    private CampaignService campaignService;
    @Autowired
    private LogService logService;

    @PostMapping("/api/Campaigns/Add")
    public CampaignDTO addCampaign(@RequestBody CampaignDTO campaign) {
        try {
            logService.logInfo("Adding campaign in CampaignController.addCampaign()");
            return campaignService.addCampaign(campaign);
        } catch (Exception e) {
            logService.logError("Failed to add campaign" + e.getMessage());
            return null;
        }
    }

    @DeleteMapping("/api/Campaigns/Delete/{id}")
    public Boolean deleteCampaign(@PathVariable String id) {
        try {
            logService.logInfo("Deleting campaign " + id + " in CampaignController.deleteCampaign()");
            return campaignService.deleteCampaign(id);
        } catch (Exception e) {
            logService.logError("Failed to delete campaign" + e.getMessage());
            return false;
        }
    }

    @PutMapping("/api/Campaigns/Update")
    public CampaignDTO updateCampaign(@RequestBody UpdateCampaignDTO campaign) {
        try {
            logService.logInfo("Updating campaign " + campaign.getId() + " in CampaignController.updateCampaign()");
            return campaignService.updateCampaign(campaign);
        } catch (Exception e) {
            logService.logError("Failed to update campaign" + e.getMessage());
            return null;
        }
    }

    @GetMapping("/api/Campaigns/Get")
    public List<CampaignDTO> getCampaigns() {
        try {
            logService.logInfo("Getting all campaigns in CampaignController.getCampaigns()");
            return campaignService.getCampaigns();
        } catch (Exception e) {
            logService.logError("Failed to get campaigns" + e.getMessage());
            return null;
        }
    }

    @GetMapping("/api/Campaigns/GetCampaignDetails/{id}")
    public CampaignDTO getCampaign(@PathVariable int id) {
        try {
            logService.logInfo("Getting campaign " + id + " in CampaignController.getCampaign()");
            return campaignService.getCampaign(id);
        } catch (Exception e) {
            logService.logError("Failed to get campaign" + e.getMessage());
            return null;
        }
    }

    @GetMapping("/api/Campaigns/GetMyCampaigns/{email}")
    public List<CampaignDTO> getMyCampaigns(@PathVariable String email) {
        try {
            logService.logInfo("Getting campaigns for " + email + " in CampaignController.getMyCampaigns()");
            return campaignService.getMyCampaigns(email);
        } catch (Exception e) {
            logService.logError("Failed to get campaigns" + e.getMessage());
            return null;
        }
    }
}