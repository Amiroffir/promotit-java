package com.amiroffir.promotitjava.repos;

import com.amiroffir.promotitjava.models.Delivery;
import com.amiroffir.promotitjava.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
}