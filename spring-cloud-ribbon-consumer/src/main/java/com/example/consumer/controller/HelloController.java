package com.example.consumer.controller;

import com.example.consumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * consumer-hello
 *
 * @author 419
 * @date 2018/6/3
 */
@RestController
public class HelloController {

    private final Logger logger = Logger.getLogger("consumer");

    @Autowired
    private HelloService helloService;

    @GetMapping("/ribbon-consumer")
    public String index(@RequestParam("name") String name) {

        return helloService.hello(name);
    }
}
