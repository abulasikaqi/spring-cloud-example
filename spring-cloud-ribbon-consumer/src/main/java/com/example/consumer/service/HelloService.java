package com.example.consumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

/**
 * @author: 419
 * @date: 2018/6/8
 */
@Service
public class HelloService {

    private final Logger logger = Logger.getLogger("HelloService ");
    @Autowired
    private RestTemplate restTemplate;

    /**
     * fallback 中的参数和调用方法的参数要一致
     * @param name
     * @return
     */
    public String helloFallback(String name) {
        return "error " + name;
    }

    @HystrixCommand(fallbackMethod = "helloFallback", commandKey = "helloKey")
    public String hello(String name) {
        long start = System.currentTimeMillis();
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
        String result = restTemplate.getForObject(url, String.class, name);
        logger.info("Spend time : " + (System.currentTimeMillis() - start));
        return result;

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
