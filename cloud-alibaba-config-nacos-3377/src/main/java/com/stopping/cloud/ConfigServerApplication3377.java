package com.stopping.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description ConfigServerApplication3377
 * @Author stopping
 * @date: 2021/4/22 16:41
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigServerApplication3377 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication3377.class,args);
    }
}
