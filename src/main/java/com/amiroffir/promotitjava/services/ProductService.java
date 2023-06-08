package com.amiroffir.promotitjava.services;

import com.amiroffir.promotitjava.DTOs.ProductDTO;
import com.amiroffir.promotitjava.models.*;
import com.amiroffir.promotitjava.repos.CampaignRepo;
import com.amiroffir.promotitjava.repos.DeliveryRepo;
import com.amiroffir.promotitjava.repos.ProductRepo;
import com.amiroffir.promotitjava.repos.UserRepo;
import com.amiroffir.promotitjava.services.LogServices.LogService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private DeliveryRepo deliveryRepo;
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CampaignRepo campaignRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private LogService logService;

    public Product[] addProducts(ProductDTO[] products) {
        Product[] updatedProducts;
        Product productToUpdate;
        try {
            if (products != null) {
                updatedProducts = new Product[products.length];
                for (int i = 0; i < products.length; i++) {
                    productToUpdate = modelMapper.map(products[i], Product.class);
                    updatedProducts[i] = productRepo.save(productToUpdate);
                }
                logService.logInfo(updatedProducts.length + " Products added successfully");
            } else {
                logService.logError("No products to add");
                return null;
            }
            return updatedProducts;
        } catch (Exception e) {
            logService.logError("Failed to add products" + e.getMessage());
            throw e;
        }
    }

    public Product[] getProducts(int campaignId) {
        try {
            Campaign campaign = campaignRepo.findById(campaignId).orElseThrow();
            Product[] products = productRepo.findAllByDonatedToAndIsBought(campaign, false);
            logService.logInfo(products.length + " Products retrieved successfully");
            return products;
        } catch (Exception e) {
            logService.logError("Failed to retrieve products" + e.getMessage());
            throw e;
        }
    }

    public Product updateBought(int id, String email) {
        try {
            Product product = productRepo.findById(id).orElseThrow();
            SocialActivist socialActivist = (SocialActivist) userRepo.findByEmail(email).orElseThrow();
            product.setBought(true);
            product.setBuyerID(socialActivist);
            // add delivery to the delivery table by the product and the buyer
            addDelivery(product, socialActivist);
            return productRepo.save(product);
        } catch (Exception e) {
            logService.logError("Failed to update product" + e.getMessage());
            throw e;
        }
    }

    private void addDelivery(Product product, SocialActivist socialActivist) {
        try {
            Delivery delivery = new Delivery();
            delivery.setProduct(product);
            delivery.setBuyer(socialActivist);
            delivery.setBusinessRep((BusinessRep) product.getDonatedBy());
            deliveryRepo.save(delivery);
            logService.logInfo("Delivery added successfully");
        } catch (Exception e) {
            logService.logError("Failed to add delivery" + e.getMessage());
            throw e;
        }
    }
}