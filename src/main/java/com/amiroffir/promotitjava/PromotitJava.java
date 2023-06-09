package com.amiroffir.promotitjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PromotitJava {

    public static void main(String[] args) {
        SpringApplication.run(PromotitJava.class, args);
    }

}

// About the project:
// This is a Java-based backend-side version of the PromotIt project which was originally written in C#.
// The goal of this project was to learn and get experience with Java and her ecosystem technologies.
// Besides that, I tried to create the server and client components as independent as possible.

// PromotIt is a web app that handles the social promotion of the non-profit organization and other related campaigns.
// The system's goal is to promote social campaigns. more about the project can be found here:https://github.com/Amiroffir/PromotIt-Web-App#readme.
// The client-side was written in Angular to the original server which was written in C#.
// It can be found here: https://github.com/Amiroffir/promotit-angular.

// Technologies used:
// Java
// Spring Boot
// Hibernate - for the ORM
// SqlServer - for the database
// Auth0 - for authentication and authorization