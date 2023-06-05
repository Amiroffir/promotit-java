package com.amiroffir.promotitjava.configurations.converters;


import com.amiroffir.promotitjava.models.Campaign;
import com.amiroffir.promotitjava.repos.CampaignRepo;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StringToCampaign implements Converter<String, Campaign> {
    @Autowired
    private CampaignRepo campaignRepo;

    @Override
    public Campaign convert(MappingContext<String, Campaign> context) {
        int id = Integer.parseInt(context.getSource());
        return campaignRepo.findById(id).orElse(null);
    }
}