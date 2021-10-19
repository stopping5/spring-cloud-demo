package com.stopping.comsumer.controller;

import com.stopping.cloud.entities.CommonResult;
import com.stopping.cloud.entities.Payment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Description OrderController
 * @Author stopping
 * @date: 2021/4/15 14:52
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    private static final String REQUEST_URL = "http://cloud-payment-service/payment/";

    @PostMapping("/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        return restTemplate.postForObject(REQUEST_URL+"create",payment,CommonResult.class);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable(name = "id")Long id){
        return restTemplate.getForObject(REQUEST_URL+"get/"+id,CommonResult.class);
    }
    @GetMapping("/payment/getZk")
    public CommonResult getZKMsg(){
        return restTemplate.getForObject(REQUEST_URL+"get/zk",CommonResult.class);
    }
}
