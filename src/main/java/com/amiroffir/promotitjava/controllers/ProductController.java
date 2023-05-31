package com.amiroffir.promotitjava.controllers;

import com.amiroffir.promotitjava.models.Product;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class ProductController {

    @PostMapping("/api/Products/Add")
    public Product addProduct(Product product) {
        return product;
    }

    @PutMapping("/api/Products/UpdateBought/{id}")
    public String updateBought(@PathVariable String id) {
        return id;
    }

    @GetMapping("/api/Products/Get/{id}")
    public String getProduct(@PathVariable String id) {
        return id;
    }
}