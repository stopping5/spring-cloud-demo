package com.stopping.clou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description StreamEKConsumer8802
 * @Author stopping
 * @date: 2021/4/20 16:50
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamEKConsumer8803 {
    public static void main(String[] args) {
        SpringApplication.run(StreamEKConsumer8803.class,args);
    }
}

