package com.amiroffir.promotitjava.services;


import com.amiroffir.promotitjava.models.SocialActivist;
import com.amiroffir.promotitjava.models.User;
import com.amiroffir.promotitjava.repos.SocialActRepo;
import com.amiroffir.promotitjava.repos.UserRepo;
import com.amiroffir.promotitjava.services.LogServices.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocialActService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private LogService logService;

    public Boolean updateWallet(String amount, String email) {
        try {
            SocialActivist socialActivist = (SocialActivist) userRepo.findByEmail(email).orElseThrow();
            socialActivist.setEarningStatus(socialActivist.getEarningStatus() - Integer.parseInt(amount));
            userRepo.save(socialActivist);
            logService.logInfo("Social activist: " + socialActivist.getFullName() + " wallet updated");
            return true;
        } catch (Exception e) {
            logService.logError("Social activist wallet update failed" + e.getMessage());
            throw e;
        }
    }

    public String getWallet(String email) {
        try {
            SocialActivist socialActivist = (SocialActivist) userRepo.findByEmail(email).orElseThrow();
            logService.logInfo("Social activist: " + socialActivist.getFullName() + " wallet retrieved");
            return String.valueOf(socialActivist.getEarningStatus());
        } catch (Exception e) {
            logService.logError("Social activist wallet retrieval failed" + e.getMessage());
            throw e;
        }
    }
}