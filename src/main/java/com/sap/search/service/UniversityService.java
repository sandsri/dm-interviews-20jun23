package com.sap.search.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class UniversityService {

    private final RestTemplate restTemplate;
    @Value("${app.search.url}:http://universities.hipolabs.com/search")
    private String url;

    public UniversityService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String searchUniversitiesByName(String name) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                .queryParam("name", name);

        ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            throw new RuntimeException("Failed to fetch universities");
        }
    }
}