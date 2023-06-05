package com.amiroffir.promotitjava.configurations;


import com.amiroffir.promotitjava.DTOs.CampaignDTO;
import com.amiroffir.promotitjava.DTOs.ProductDTO;
import com.amiroffir.promotitjava.configurations.converters.EmailToUserConverter;
import com.amiroffir.promotitjava.configurations.converters.StringToCampaign;
import com.amiroffir.promotitjava.configurations.converters.UserToOrgName;
import com.amiroffir.promotitjava.models.Campaign;
import com.amiroffir.promotitjava.models.Delivery;
import com.amiroffir.promotitjava.models.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Autowired
    private EmailToUserConverter emailToUserConverter;
    @Autowired
    private UserToOrgName userToOrgName;
    @Autowired
    private StringToCampaign stringToCampaign;


    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // Configure the mapping for the nonProfitRep field
        modelMapper.typeMap(CampaignDTO.class, Campaign.class)
                .addMappings(mapping -> mapping.using(emailToUserConverter).map(CampaignDTO::getNonProfitRep, Campaign::setNonProfitRep));
        modelMapper.typeMap(Campaign.class, CampaignDTO.class)
                .addMappings(mapping -> mapping.using(userToOrgName).map(Campaign::getNonProfitRep, CampaignDTO::setNonProfitRep));
        modelMapper.typeMap(ProductDTO.class, Product.class)
                .addMappings(mapping -> {
                    mapping.using(stringToCampaign).map(ProductDTO::getDonatedTo, Product::setDonatedTo);
                    mapping.using(emailToUserConverter).map(ProductDTO::getDonatedBy, Product::setDonatedBy);
                });


        return modelMapper;
    }
}