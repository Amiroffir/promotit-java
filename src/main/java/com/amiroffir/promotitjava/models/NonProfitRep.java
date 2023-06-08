package com.amiroffir.promotitjava.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue("non_profit_rep")
public class NonProfitRep extends User {

    private String organizationUrl;
    private String organizationName;
}