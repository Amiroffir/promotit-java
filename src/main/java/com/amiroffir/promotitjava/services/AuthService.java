package com.amiroffir.promotitjava.services;


import com.amiroffir.promotitjava.services.LogServices.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthService {
    @Autowired
    private LogService logService;
    @Autowired
    private HttpEntity<String> entity;
    @Value("${auth0.endpoint}")
    private String auth0End;


    public String getRolesFromAuth0(String userID) {
        String urlGetRoles = auth0End + "/" + userID + "/roles";
        try {
            logService.logInfo("Getting roles from Auth0");
            return new RestTemplate().exchange(urlGetRoles, HttpMethod.GET, entity, String.class).getBody();
        } catch (RestClientException e) {
            logService.logError("Error getting roles from Auth0" + e.getMessage());
            throw e;
        }
    }
}