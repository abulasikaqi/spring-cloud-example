package com.example.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by LL on 2018/6/3 0003.
 */
@RestController
public class UserController {

    private final Logger logger = Logger.getLogger("home");

    @Autowired
    private DiscoveryClient client;

    @GetMapping("/user")
    public String index(@RequestParam("name") String name) {

        List<ServiceInstance> instances = client.getInstances("user-service");
        for (ServiceInstance instance : instances) {

            logger.info("/user, uri:" + instance.getUri() +
                    ", host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", port:" + instance.getPort());
        }

        logger.info("Hello " + name);

        return "Hello " + name;
    }
}
