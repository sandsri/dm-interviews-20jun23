package com.second.challenge.controller;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class UniversitySearchController {

    @GetMapping("/search")
    public String search(@RequestParam("name") String name) throws IOException {
        // Create the HttpClient instance
        HttpClient httpClient = HttpClientBuilder.create().build();

        // Create the HTTP GET request with the specified URL and query parameter
        String url = "http://universities.hipolabs.com/search?name=" + name;
        HttpGet request = new HttpGet(url);

        // Execute the request and retrieve the response
        HttpResponse response = httpClient.execute(request);

        // Extract the response body as a String
        HttpEntity entity = response.getEntity();
        String responseBody = EntityUtils.toString(entity);

        // Return the response body
        return responseBody;
    }
}
