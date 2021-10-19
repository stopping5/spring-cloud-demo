package com.stopping.comsumer.controller;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import com.stopping.cloud.entities.CommonResult;
import com.stopping.cloud.entities.Payment;
import com.stopping.comsumer.config.MySelfRule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description OrderController
 * @Author stopping
 * @date: 2021/4/15 14:52
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    private static final String REQUEST_URL = "http://cloud-payment-service/payment/";

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private MySelfRule mySelfRule;

    @PostMapping("/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        return restTemplate.postForObject(REQUEST_URL+"create",payment,CommonResult.class);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable(name = "id")Long id){
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("cloud-payment-service");
        ServiceInstance serviceInstance = mySelfRule.getServiceInstance(serviceInstances);
        String  path = serviceInstance.getUri()+"/payment/get/"+id;
        log.info("host:{},uri:{}", serviceInstance.getHost(),path);
        return restTemplate.getForObject( path,CommonResult.class);
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin()
    {
        String result = restTemplate.getForObject(REQUEST_URL+"zipkin", String.class);
        return result;
    }

}
