package com.amiroffir.promotitjava.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Data
public class DeliveryDTO {
    @Id
    @JsonProperty("ProductSerialNumber")
    private int productSerialNumber;
    @JsonProperty("PID")
    private String pid;
    @JsonProperty("FullName")
    private String fullName;
    @JsonProperty("Email")
    private String email;
    @JsonProperty("Address")
    private String address;
    @JsonProperty("Phone")
    private String phone;
}