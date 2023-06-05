package com.amiroffir.promotitjava.repos;

import com.amiroffir.promotitjava.models.Campaign;
import com.amiroffir.promotitjava.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignRepo extends JpaRepository<Campaign, Integer> {
    List<Campaign> findByNonProfitRep(User nonProfitRep);
}