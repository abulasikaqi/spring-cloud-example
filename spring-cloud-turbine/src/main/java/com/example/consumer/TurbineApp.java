package com.example.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * Hystrix 仪表盘
 * @author 419
 */
@EnableTurbine
@EnableDiscoveryClient
@SpringBootApplication
public class TurbineApp {

    public static void main(String[] args) {

        SpringApplication.run(TurbineApp.class, args);
    }
}
