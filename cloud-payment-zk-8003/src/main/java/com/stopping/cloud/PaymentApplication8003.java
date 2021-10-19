package com.stopping.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description PaymentApplication
 * @Author stopping
 * @date: 2021/4/15 11:14
 */
@SpringBootApplication
//启动服务发现
@EnableDiscoveryClient
public class PaymentApplication8003 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication8003.class,args);
    }
}
