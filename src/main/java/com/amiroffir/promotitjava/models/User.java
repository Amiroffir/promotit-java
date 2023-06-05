package com.amiroffir.promotitjava.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "`user`")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("userID")
    public int user_id;
    @JsonProperty("userType")
    @Column(insertable = false, updatable = false)
    public String user_type;
    public String fullName;
    public String email;
}