package com.example.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

/**
 * consumer-hello
 * @author 419
 * @date 2018/6/3
 */
@RestController
public class ConsumerController {

    private final Logger logger = Logger.getLogger("consumer");

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/ribbon-consumer")
    public String index() {
        return restTemplate.getForEntity("http://hello-service/hello", String.class).getBody();
    }
}
