package com.amiroffir.promotitjava.services;

import com.amiroffir.promotitjava.DTOs.ProductDTO;
import com.amiroffir.promotitjava.models.*;
import com.amiroffir.promotitjava.repos.CampaignRepo;
import com.amiroffir.promotitjava.repos.DeliveryRepo;
import com.amiroffir.promotitjava.repos.ProductRepo;
import com.amiroffir.promotitjava.repos.UserRepo;
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
            } else {
                return null;
            }
            return updatedProducts;
        } catch (Exception e) {
            throw e;
        }
    }

    public Product[] getProducts(int campaignId) {
        try {
            Campaign campaign = campaignRepo.findById(campaignId).orElseThrow();
            Product[] products = productRepo.findAllByDonatedToAndIsBought(campaign, false);
            return products;
        } catch (Exception e) {
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
        } catch (Exception e) {
            throw e;
        }
    }
}