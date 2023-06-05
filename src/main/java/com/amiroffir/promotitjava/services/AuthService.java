package com.amiroffir.promotitjava.services;


import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthService {

    @Value("${auth0.endpoint}")
    private String auth0End;

    @Value("${auth0.bearer}")
    private String bearerAuth0;

    public String getRolesFromAuth0(String userID) {
        String urlGetRoles = auth0End + "/" + userID + "/roles";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", bearerAuth0);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        try {
            return restTemplate.exchange(urlGetRoles, HttpMethod.GET, entity, String.class).getBody();
        } catch (Exception e) {
            throw e;
        }
    }
}