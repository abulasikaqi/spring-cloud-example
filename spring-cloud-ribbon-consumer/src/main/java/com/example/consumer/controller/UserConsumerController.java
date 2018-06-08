package com.example.consumer.controller;

import com.example.consumer.entity.User;
import com.example.consumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

/**
 * @author 419
 */
@RestController
public class UserConsumerController {

    @Autowired
    private UserService userService;

    @GetMapping("user-info")
    public User userInfo(@RequestParam("name") String name) {

        return userService.getUserInfo(name);
    }

    @GetMapping("user-info-sync")
    public User userInfoSync(@RequestParam("name") String name) throws ExecutionException, InterruptedException {

        return userService.getUserInfoSync(name).get();
    }
}
