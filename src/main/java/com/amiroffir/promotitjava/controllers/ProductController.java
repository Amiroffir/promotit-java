package com.amiroffir.promotitjava.controllers;

import com.amiroffir.promotitjava.DTOs.ProductDTO;
import com.amiroffir.promotitjava.models.Product;
import com.amiroffir.promotitjava.services.LogServices.LogService;
import com.amiroffir.promotitjava.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private LogService logService;

    @PostMapping("/api/Products/Add")
    public ResponseEntity<Product[]> addProduct(@RequestBody ProductDTO[] products) {
        try {
            logService.logInfo("Adding products in ProductController.addProduct()");
            Product[] productsResponse = productService.addProducts(products);
            return ResponseEntity.ok(productsResponse);
        } catch (Exception e) {
            logService.logError("Failed to add products " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/api/Products/UpdateBought/{id}")
    public ResponseEntity<Product> updateBought(@PathVariable int id, @RequestBody String email) {
        try {
            logService.logInfo("Updating bought in ProductController.updateBought()");
            Product productResponse = productService.updateBought(id, email);
            if (productResponse == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            } else {
                return ResponseEntity.ok(productResponse);
            }
        } catch (Exception e) {
            logService.logError("Failed to update bought " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/api/Products/Get/{campaignId}")
    public ResponseEntity<Product[]> getProducts(@PathVariable int campaignId) {
        try {
            logService.logInfo("Getting products in ProductController.getProducts()");
            Product[] productsResponse = productService.getProducts(campaignId);
            return ResponseEntity.ok(productsResponse);
        } catch (Exception e) {
            logService.logError("Failed to get products " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}