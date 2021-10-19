package com.stopping.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description Config4433Application
 * @Author stopping
 * @date: 2021/4/19 16:39
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@EnableConfigServer
public class Config4433Application {
    public static void main(String[] args) {
        SpringApplication.run(Config4433Application.class,args);
    }
}
