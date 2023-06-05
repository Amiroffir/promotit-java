package com.amiroffir.promotitjava.configurations.converters;

import com.amiroffir.promotitjava.models.NonProfitRep;
import com.amiroffir.promotitjava.models.User;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

@Component
public class UserToOrgName implements Converter<User, String> {
    @Override
    public String convert(MappingContext<User, String> mappingContext) {
        NonProfitRep nonProfitRep = (NonProfitRep) mappingContext.getSource();
        return nonProfitRep.getOrganizationName();
    }
}