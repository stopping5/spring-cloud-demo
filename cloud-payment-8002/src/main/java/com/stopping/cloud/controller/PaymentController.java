package com.stopping.cloud.controller;

import com.stopping.cloud.entities.CommonResult;
import com.stopping.cloud.entities.Payment;
import com.stopping.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Description PaymentConrtoller
 * @Author stopping
 * @date: 2021/4/15 11:51
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("插入结果:{},{}",result,port);
        return CommonResult.success(result);
    }
    @GetMapping("/get/{paymentId}")
    public CommonResult getPaymentById(@PathVariable(name = "paymentId")Long id){
        log.info("port:{}",port);
        return CommonResult.success(paymentService.getPaymentById(id));
    }

    @GetMapping("/discovery")
    public CommonResult discovery(){
        log.info("description:{}",discoveryClient.description());
        for (String service : discoveryClient.getServices()){
            log.info("service:{}",service);
        }
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance s : serviceInstances){
            log.info("serviceInstance:{}",s);

        }
        return CommonResult.success(discoveryClient);
    }
    @GetMapping("/timeout")
    public CommonResult timeout() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        return CommonResult.success(port);
    }
}
