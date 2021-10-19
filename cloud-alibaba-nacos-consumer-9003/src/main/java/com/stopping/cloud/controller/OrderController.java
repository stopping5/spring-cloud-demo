package com.stopping.cloud.controller;

import com.stopping.cloud.entities.CommonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description OrderController
 * @Author stopping
 * @date: 2021/4/22 15:36
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
    private RestTemplate restTemplate;
    @Value("${service.provider.payment-url}")
    private String PAYMENT_SERVICE;

    @GetMapping("/payment/get/{id}")
    public String getPaymentById(@PathVariable(name = "id")Long id){
        return restTemplate.getForObject(PAYMENT_SERVICE+"/payment/nacos/"+id,String.class);
    }

    @GetMapping("/payment/sell")
    public String sell(){
        return restTemplate.getForObject(PAYMENT_SERVICE+"/payment/sell",String.class);
    }
}
