package com.example.demo.controller;

import com.example.demo.response.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/api/rest")
@RestController
public class RestTempleteController {

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getInventoryDetails(@RequestParam String name) {
        RestTemplate resttemplete = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<?> entity = new HttpEntity<>(name, headers);
        String value = resttemplete.getForObject("http://universities.hipolabs.com/search?name="+name
               ,String.class ,entity);
        CommonResponse resp = new CommonResponse();
        resp.setData(value);
        resp.setMessage("success");
        resp.setStatusCode(200);
        return resp;
    }


}
