package com.amiroffir.promotitjava.repos;

import com.amiroffir.promotitjava.models.Delivery;
import com.amiroffir.promotitjava.models.NonProfitRep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NonProfitRepo extends JpaRepository<NonProfitRep, Integer> {
}