package com.stopping.top;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description PaymentProviderApplication90001
 * @Author stopping
 * @date: 2021/4/22 12:16
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentProviderApplication90001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentProviderApplication90001.class,args);
    }
}
