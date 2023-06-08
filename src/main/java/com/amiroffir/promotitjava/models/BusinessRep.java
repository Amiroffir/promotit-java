package com.amiroffir.promotitjava.models;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue("business_rep")
public class BusinessRep extends User {
    private String companyName;

}