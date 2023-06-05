package com.amiroffir.promotitjava.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue("non_profit_rep")
public class NonProfitRep extends User {

    public String organizationUrl;
    public String organizationName;
}