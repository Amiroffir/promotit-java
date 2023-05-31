package com.amiroffir.promotitjava.services;

import com.amiroffir.promotitjava.repos.CampaignRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampaignService {

    @Autowired
    private CampaignRepo campaignRepo;
}