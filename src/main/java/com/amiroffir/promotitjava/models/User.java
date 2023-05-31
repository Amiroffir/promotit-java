package com.amiroffir.promotitjava.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "`user`")
public class User {
    @Id
    public int id;
}