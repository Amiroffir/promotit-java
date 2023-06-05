package com.amiroffir.promotitjava.configurations.converters;

import com.amiroffir.promotitjava.models.User;

import com.amiroffir.promotitjava.repos.UserRepo;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailToUserConverter implements Converter<String, User> {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User convert(MappingContext<String, User> context) {
        String email = context.getSource();
        return userRepo.findByEmail(email).orElseThrow();
    }
}