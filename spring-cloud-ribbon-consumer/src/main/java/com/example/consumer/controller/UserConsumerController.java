package com.example.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("ribbon-consumer-user-get")
    public String getUser(@RequestParam("name") String name) {
        String url = //"http://user-service/user?name={1}"; // 1
                "http://user-service/user?name={name}"; //2
        ResponseEntity<String> responseEntity = null;

//        responseEntity = restTemplate.getForEntity(url, String.class, name); // 1

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("name", name);
        responseEntity = restTemplate.getForEntity(url, String.class, paramMap); // 2

        return responseEntity.getBody();
    }

}
