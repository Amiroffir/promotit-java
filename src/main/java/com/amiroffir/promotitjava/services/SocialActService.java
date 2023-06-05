package com.amiroffir.promotitjava.services;


import com.amiroffir.promotitjava.models.SocialActivist;
import com.amiroffir.promotitjava.models.User;
import com.amiroffir.promotitjava.repos.SocialActRepo;
import com.amiroffir.promotitjava.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocialActService {

    @Autowired
    private UserRepo userRepo;

    public Boolean updateWallet(String amount, String email) {
        try {
            SocialActivist socialActivist = (SocialActivist) userRepo.findByEmail(email).orElseThrow();
            socialActivist.setEarningStatus(socialActivist.getEarningStatus() - Integer.parseInt(amount));
            userRepo.save(socialActivist);
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    public String getWallet(String email) {
        try {
            SocialActivist socialActivist = (SocialActivist) userRepo.findByEmail(email).orElseThrow();
            return String.valueOf(socialActivist.getEarningStatus());
        } catch (Exception e) {
            throw e;
        }
    }
}