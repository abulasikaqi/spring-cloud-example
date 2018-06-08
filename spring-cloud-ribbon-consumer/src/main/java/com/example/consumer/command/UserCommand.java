package com.example.consumer.command;

import com.example.consumer.entity.User;
import com.netflix.hystrix.HystrixCommand;
import org.springframework.web.client.RestTemplate;

/**
 * 创建请求命令
 * @author: 419
 * @date: 2018/6/8
 */
public class UserCommand extends HystrixCommand<User> {

    private RestTemplate restTemplate;

    private String name;

    public UserCommand(Setter setter, RestTemplate restTemplate, String name) {
        super(setter);
        this.restTemplate = restTemplate;
        this.name = name;
    }

    @Override
    protected User run() throws Exception {
        return restTemplate.getForObject("http://user-service/user?name={1}", User.class, name);
    }

    @Override
    protected User getFallback() {
        return new User();
    }
}
