package com.example.consumer.service;

import com.example.consumer.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rx.Observable;

import java.util.concurrent.Future;

/**
 * 注解版 HystrixCommand
 * @author: 419
 * @date: 2018/6/8
 */
@Service
public class UserService {


    @Autowired
    private RestTemplate restTemplate;

    /**
     * fallback
     * @return
     */
    private User defaultUser(String name) {
        return new User();
    }

    @HystrixCommand(fallbackMethod = "defaultUser", ignoreExceptions = Exception.class)
    public User getUserInfo(String name) {

        return restTemplate.getForObject("http://user-service/user?name={1}", User.class, name);
    }

    @HystrixCommand
    public Future<User> getUserInfoSync(final String name) {

        return new AsyncResult<User>() {
            @Override
            public User invoke() {
                return restTemplate.getForObject("http://user-service/user?name={1}", User.class, name);
            }
        };
    }

    @HystrixCommand
    public Observable<User> getUserInfoObs(final String name) {

        return Observable.unsafeCreate(subscriber -> {
            if (!subscriber.isUnsubscribed()) {
                User user = restTemplate.getForObject("http://user-service/user?name={1}", User.class, name);

                subscriber.onNext(user);
                subscriber.onCompleted();
            }
        });
    }
}
