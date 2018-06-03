package com.example.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

/**
 * Created by LL on 2018/6/3 0003.
 */
@RestController
public class ConsumerController {

    private final Logger logger = Logger.getLogger("consumer");

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
    public String index() {
        return restTemplate.getForEntity("http://hello-service/hello", String.class).getBody();
    }
}
