package com.amiroffir.promotitjava.repos;

import com.amiroffir.promotitjava.models.Campaign;
import com.amiroffir.promotitjava.models.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignRepo extends JpaRepository<Campaign, Integer> {
}