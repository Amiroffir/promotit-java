package com.amiroffir.promotitjava.services;

import com.amiroffir.promotitjava.DTOs.ProductDTO;
import com.amiroffir.promotitjava.models.Campaign;
import com.amiroffir.promotitjava.models.Product;
import com.amiroffir.promotitjava.models.SocialActivist;
import com.amiroffir.promotitjava.repos.CampaignRepo;
import com.amiroffir.promotitjava.repos.ProductRepo;
import com.amiroffir.promotitjava.repos.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
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

    public Product[] getProducts(Integer campaignId) {
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
            productRepo.save(product);
            return product;
        } catch (Exception e) {
            throw e;
        }
    }
}