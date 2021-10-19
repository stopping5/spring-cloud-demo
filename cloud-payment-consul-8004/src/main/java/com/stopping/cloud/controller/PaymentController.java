package com.stopping.cloud.controller;

import com.stopping.cloud.entities.CommonResult;
import com.stopping.cloud.entities.Payment;
import com.stopping.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.UUID;

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
    @GetMapping("/get/consul")
    public CommonResult getConsul(){
        return CommonResult.success("consul:port-"+port+":msg"+ UUID.randomUUID());
    }
}
