package com.interview.ayush_2.controller;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
@RestController
@RequestMapping(path = "/api/v1/")
public class SearchController {

    @GetMapping(value="search")
    public String search(@RequestParam String name){
        HttpClient httpClient = HttpClientBuilder.create().build();
        String url = "http://universities.hipolabs.com/search?name=" + name;
        HttpGet getRequest = new HttpGet(url);
        HttpResponse response = httpClient.execute(getRequest);
        HttpEntity entity = response.getEntity();
        String responseBody = EntityUtils.toString(entity);
        return responseBody;
    }
}
