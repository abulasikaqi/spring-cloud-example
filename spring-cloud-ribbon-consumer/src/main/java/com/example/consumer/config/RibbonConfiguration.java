package com.example.consumer.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;

/**
 * @author: 419
 * @date: 2018/6/8
 */
//@Configuration
public class RibbonConfiguration {

    @Bean
    public IRule ribbonRule() {

        return
//                new BestAvailableRule(); // 最小并发
//                new WeightedResponseTimeRule(); // 权重（响应时间）
//                new RetryRule(); // 线性轮询（重试机制）
//                new RandomRule(); // 随机负载
                new RoundRobinRule(); // 线性轮询（默认）
    }
}
