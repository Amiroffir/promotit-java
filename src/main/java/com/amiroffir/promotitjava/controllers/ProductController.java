package com.amiroffir.promotitjava.controllers;

import com.amiroffir.promotitjava.DTOs.ProductDTO;
import com.amiroffir.promotitjava.models.Product;
import com.amiroffir.promotitjava.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/api/Products/Add")
    public Product[] addProduct(@RequestBody ProductDTO[] products) {
        try {
            return productService.addProducts(products);
        } catch (Exception e) {
            return null;
        }
    }

    @PutMapping("/api/Products/UpdateBought/{id}")
    public Product updateBought(@PathVariable int id, @RequestBody String email) {
        try {
            return productService.updateBought(id, email);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/api/Products/Get/{campaignId}")
    public Product[] getProducts(@PathVariable int campaignId) {
        try {
            return productService.getProducts(campaignId);
        } catch (Exception e) {
            return null;
        }
    }
}