package com.amiroffir.promotitjava.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
//@Table(name = "Delivery")
// @NoArgsConstructor - Basically, this annotation will generate a constructor with no parameters.
// but since we use @Data, we don't need it, and it will even cause an error.
// @AllArgsConstructor - This annotation will generate a constructor with 1 parameter for each field in your class.
// @RequiredArgsConstructor - This annotation will generate a constructor with 1 parameter for each field that requires special handling.
public class Delivery {
    @Id
    private int productSerialNumber;
    private int PID;
    private String FullName;
    private String Email;
    private String Address;
    private String Phone;

}