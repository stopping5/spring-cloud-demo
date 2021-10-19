package com.stopping.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.stopping.cloud.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Description PaymentController
 * @Author stopping
 * @date: 2021/4/17 15:58
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String port;

    @GetMapping("/getOk")
    public CommonResult requestOk(){
        return CommonResult.success("hello world - getOk");
    }
    @GetMapping("/getTimeout")
    @HystrixCommand(
        fallbackMethod = "requestTimeoutHandler",
        commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
        }
    )
    public CommonResult requestTimeout() throws InterruptedException {
        log.info("request timeout : {}",Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(5);
        return CommonResult.success("hello world - requestTimeout");
    }

    public CommonResult requestTimeoutHandler(){
        log.info("payment service - 降级处理");
        return CommonResult.fail("sorry,the service is timeout");
    }
}
