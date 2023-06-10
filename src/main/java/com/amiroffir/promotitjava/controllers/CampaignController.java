package com.amiroffir.promotitjava.controllers;

import com.amiroffir.promotitjava.DTOs.CampaignDTO;
import com.amiroffir.promotitjava.DTOs.UpdateCampaignDTO;
import com.amiroffir.promotitjava.services.CampaignService;
import com.amiroffir.promotitjava.services.LogServices.LogService;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<CampaignDTO> addCampaign(@RequestBody CampaignDTO campaign) {
        try {
            logService.logInfo("Adding campaign in CampaignController.addCampaign()");
            CampaignDTO addedCampaign = campaignService.addCampaign(campaign);
            return ResponseEntity.status(HttpStatus.CREATED).body(addedCampaign);
        } catch (Exception e) {
            logService.logError("Failed to add campaign" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/api/Campaigns/Delete/{id}")
    public ResponseEntity<Boolean> deleteCampaign(@PathVariable String id) {
        try {
            logService.logInfo("Deleting campaign " + id + " in CampaignController.deleteCampaign()");
            boolean isDeleted = campaignService.deleteCampaign(id);
            if (isDeleted) {
                return ResponseEntity.ok(true);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
            }
        } catch (Exception e) {
            logService.logError("Failed to delete campaign" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/api/Campaigns/Update")
    public ResponseEntity<CampaignDTO> updateCampaign(@RequestBody UpdateCampaignDTO campaign) {
        try {
            logService.logInfo("Updating campaign " + campaign.getId() + " in CampaignController.updateCampaign()");
            CampaignDTO updatedCampaign = campaignService.updateCampaign(campaign);
            if (updatedCampaign == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            } else {
                return ResponseEntity.ok(updatedCampaign);
            }
        } catch (Exception e) {
            logService.logError("Failed to update campaign" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/api/Campaigns/Get")
    public ResponseEntity<List<CampaignDTO>> getCampaigns() {
        try {
            logService.logInfo("Getting all campaigns in CampaignController.getCampaigns()");
            List<CampaignDTO> campaigns = campaignService.getCampaigns();
            return ResponseEntity.ok(campaigns);
        } catch (Exception e) {
            logService.logError("Failed to get campaigns" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/api/Campaigns/GetCampaignDetails/{id}")
    public ResponseEntity<CampaignDTO> getCampaign(@PathVariable int id) {
        try {
            logService.logInfo("Getting campaign " + id + " in CampaignController.getCampaign()");
            CampaignDTO campaign = campaignService.getCampaign(id);
            if (campaign == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            } else {
                return ResponseEntity.ok(campaign);
            }
        } catch (Exception e) {
            logService.logError("Failed to get campaign" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/api/Campaigns/GetMyCampaigns/{email}")
    public ResponseEntity<List<CampaignDTO>> getMyCampaigns(@PathVariable String email) {
        try {
            logService.logInfo("Getting campaigns for " + email + " in CampaignController.getMyCampaigns()");
            List<CampaignDTO> campaigns = campaignService.getMyCampaigns(email);
            return ResponseEntity.ok(campaigns);
        } catch (Exception e) {
            logService.logError("Failed to get campaigns" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}