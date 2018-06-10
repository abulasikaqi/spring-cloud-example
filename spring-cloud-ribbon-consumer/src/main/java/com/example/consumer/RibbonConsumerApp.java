package com.example.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Main
 * EnableCircuitBreaker 开启断路器功能
 *
 * @author 419
 */
@SpringCloudApplication
public class RibbonConsumerApp {

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {

        SpringApplication.run(RibbonConsumerApp.class, args);
    }
}
