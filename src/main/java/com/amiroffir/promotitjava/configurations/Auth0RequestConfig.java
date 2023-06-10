package com.amiroffir.promotitjava.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.function.ServerRequest;

@Configuration
public class Auth0RequestConfig {
    @Value("${auth0.bearer}")
    private String bearerAuth0;

    @Bean
    public HttpEntity<String> httpEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", bearerAuth0);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return entity;
    }
}