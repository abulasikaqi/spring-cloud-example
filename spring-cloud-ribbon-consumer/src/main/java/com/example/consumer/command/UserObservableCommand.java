package com.example.consumer.command;

import com.example.consumer.entity.User;
import com.netflix.hystrix.HystrixObservableCommand;
import org.springframework.web.client.RestTemplate;
import rx.Observable;
import rx.Subscriber;

/**
 * @author: 419
 * @date: 2018/6/8
 */
public class UserObservableCommand extends HystrixObservableCommand<User> {

    private RestTemplate restTemplate;

    private String name;

    public UserObservableCommand(Setter setter, RestTemplate restTemplate, String name) {
        super(setter);
        this.restTemplate = restTemplate;
        this.name = name;
    }

    @Override
    protected Observable<User> construct() {
        return Observable.unsafeCreate(new Observable.OnSubscribe<User>(){

            @Override
            public void call(Subscriber<? super User> subscriber) {
                if (!subscriber.isUnsubscribed()) {
                    User user = restTemplate.getForObject("http://user-service/user?name={1}", User.class, name);

                    subscriber.onNext(user);
                    subscriber.onCompleted();
                }
            }
        });
    }
}
