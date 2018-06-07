package com.example.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

/**
 * consumer-hello
 *
 * @author 419
 * @date 2018/6/3
 */
@RestController
public class ConsumerController {

    private final Logger logger = Logger.getLogger("consumer");

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/ribbon-consumer")
    public String index(@RequestParam("name") String name) {
        // TODO getForEntity
        // 1
//        String url = "http://hello-service/hello?name={1}";
//        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class, name);

        // 2
//        String url = "http://hello-service/hello?name={name}";
//        Map<String, Object> map = new HashMap<>(1);
//        map.put("name", "419");
//        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class, map);
//        return responseEntity.getBody();

        // 3
//        UriComponents uriComponents = UriComponentsBuilder.fromUriString("http://hello-service/hello?name={name}")
//                .build()
//                .expand(name)
//                .encode();
//        URI uri = uriComponents.toUri();
//        return restTemplate.getForEntity(uri, String.class).getBody();


        // TODO getForObject
        // 1
        String url = "http://hello-service/hello?name={1}";
        return restTemplate.getForObject(url, String.class, name);

        // 2
//        String url = "http://hello-service/hello?name={name}";
//        Map<String, Object> map = new HashMap<>(1);
//        map.put("name", name);
//        return restTemplate.getForObject(url, String.class, map);

//        UriComponents uriComponents = UriComponentsBuilder.fromUriString("http://hello-service/hello?name={name}")
//                .build()
//                .expand(name)
//                .encode();
//        URI uri = uriComponents.toUri();
//
//        return restTemplate.getForObject(uri, String.class);
    }
}
