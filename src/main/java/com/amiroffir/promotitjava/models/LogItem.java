package com.amiroffir.promotitjava.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "logs")
public class LogItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String level;
    @Column(length = 1000)
    private String message;

    public LogItem() {
    }

    public LogItem(String level, String message) {
        this.level = level;
        this.message = message;
    }
}