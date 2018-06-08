package com.example.server;

import com.example.server.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 *
 * @author 419
 * @date 2018/6/3
 */
@RestController
public class UserController {

    private final Logger logger = Logger.getLogger("user");

//    @Autowired
//    private DiscoveryClient client;

    @GetMapping("/user")
    public User index(@RequestParam("id") int id, @RequestParam("name") String name) {

//        List<ServiceInstance> instances = client.getInstances("user-service");
//        for (ServiceInstance instance : instances) {
//
//            logger.info("/user, uri:" + instance.getUri() +
//                    ", host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", port:" + instance.getPort());
//        }

        User info = new User(id, "Hello " + name);

        logger.info(info.toString());

        return info;
    }
}
