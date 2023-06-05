package com.amiroffir.promotitjava.configurations.converters;

import com.amiroffir.promotitjava.DTOs.DeliveryDTO;
import com.amiroffir.promotitjava.models.Delivery;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

@Component
public class DeliveryToDeliveryDTO implements Converter<Delivery, DeliveryDTO> {
    @Override
    public DeliveryDTO convert(MappingContext<Delivery, DeliveryDTO> mappingContext) {
        Delivery delivery = mappingContext.getSource();
        DeliveryDTO deliveryDTO = new DeliveryDTO();

        deliveryDTO.setProductSerialNumber(delivery.getProduct().getId());
        deliveryDTO.setEmail(delivery.getBuyer().getEmail());
        deliveryDTO.setPid(delivery.getProduct().getProductId());
        deliveryDTO.setAddress(delivery.getBuyer().getAddress());
        deliveryDTO.setFullName(delivery.getBuyer().getFullName());
        deliveryDTO.setPhone(delivery.getBuyer().getPhone());

        return deliveryDTO;
    }
}