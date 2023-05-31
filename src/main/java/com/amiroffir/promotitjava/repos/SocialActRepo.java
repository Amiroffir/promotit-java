package com.amiroffir.promotitjava.repos;

import com.amiroffir.promotitjava.models.Delivery;
import com.amiroffir.promotitjava.models.SocialActivist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialActRepo extends JpaRepository<SocialActivist, Integer> {
}