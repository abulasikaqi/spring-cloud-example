package com.example.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by LL on 2018/6/3 0003.
 */
@RestController
public class HelloController {

    private final Logger logger = Logger.getLogger("home");

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index() {

        List<ServiceInstance> instance = client.getInstances("hello-service");
        for (ServiceInstance serviceInstance : instance) {

            logger.info("/hello, host:" + serviceInstance.getHost() + ", service_id:" + serviceInstance.getServiceId());
        }

        return "Hello World!";
    }
}
