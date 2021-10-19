package com.stopping.comsumer;

import com.stopping.comsumer.config.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Description ComsumerOrderApplication
 * @Author stopping
 * @date: 2021/4/15 12:39
 */
@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "cloud-payment-service",configuration = MySelfRule.class)
public class ConsumerOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderApplication.class,args);
    }
}
