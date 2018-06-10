package com.example.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka 注册中心
 *
 * EnableEurekaServer 启动一个服务注册中心提供给其他应用进行对话
 * @author 419
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaApp {

    public static void main(String[] args) {
//        new SpringApplicationBuilder(EurekaApp.class).web(true).run(args);
        SpringApplication.run(EurekaApp.class, args);
    }
}
