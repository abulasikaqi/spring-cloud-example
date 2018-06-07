package com.example.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 419
 */
@RestController
public class UserConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("ribbon-consumer-user-get")
    public String getUser(@RequestParam("name") String name) {

        String url = "http://user-service/user?name={1}";

        return restTemplate.getForObject(url, String.class, name);
    }

}
