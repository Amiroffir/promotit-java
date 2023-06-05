package com.amiroffir.promotitjava.repos;

import com.amiroffir.promotitjava.models.BusinessRep;
import com.amiroffir.promotitjava.models.Campaign;
import com.amiroffir.promotitjava.models.Delivery;
import com.amiroffir.promotitjava.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
    Product[] findAllByDonatedToAndIsBought(Campaign campaign, boolean isBought);

    Product[] findAllByDonatedByAndIsBought(BusinessRep businessRep, boolean isBought);


}