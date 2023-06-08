package com.amiroffir.promotitjava.controllers;

import com.amiroffir.promotitjava.DTOs.ProductDTO;
import com.amiroffir.promotitjava.models.Product;
import com.amiroffir.promotitjava.services.LogServices.LogService;
import com.amiroffir.promotitjava.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private LogService logService;

    @PostMapping("/api/Products/Add")
    public Product[] addProduct(@RequestBody ProductDTO[] products) {
        try {
            logService.logInfo("Adding products in ProductController.addProduct()");
            return productService.addProducts(products);
        } catch (Exception e) {
            logService.logError("Failed to add products " + e.getMessage());
            return null;
        }
    }

    @PutMapping("/api/Products/UpdateBought/{id}")
    public Product updateBought(@PathVariable int id, @RequestBody String email) {
        try {
            logService.logInfo("Updating bought in ProductController.updateBought()");
            return productService.updateBought(id, email);
        } catch (Exception e) {
            logService.logError("Failed to update bought " + e.getMessage());
            return null;
        }
    }

    @GetMapping("/api/Products/Get/{campaignId}")
    public Product[] getProducts(@PathVariable int campaignId) {
        try {
            logService.logInfo("Getting products in ProductController.getProducts()");
            return productService.getProducts(campaignId);
        } catch (Exception e) {
            logService.logError("Failed to get products " + e.getMessage());
            return null;
        }
    }
}