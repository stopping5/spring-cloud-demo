package com.stopping.comsumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.stopping.cloud.entities.CommonResult;
import com.stopping.comsumer.feignService.PayServiceFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Description OrderController
 * @Author stopping
 * @date: 2021/4/17 16:31
 */
@RestController
@RequestMapping("/order")
@Slf4j
@DefaultProperties(defaultFallback = "globalFallbackMethod")
public class OrderController {
    @Resource
    private PayServiceFeign payServiceFeign;

    @GetMapping("/getOk")
    @HystrixCommand
    public CommonResult getOk(){
        return payServiceFeign.requestOk();
    }

    @GetMapping("/getTimeout")
    @HystrixCommand(fallbackMethod = "fallBackMethodHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })
    public CommonResult getTimeout(){
        log.info("order-80-getTimeout-requestTimeout O(∩_∩)O哈哈~");
        return payServiceFeign.requestTimeout();
    }

    @GetMapping("/User")
    @HystrixCommand(
        fallbackMethod = "getUserIdHandler",
        commandProperties = {
                //开启熔断
                @HystrixProperty(name = "circuitBreaker.enabled",value = "true" ),
                //请求次数超过了峰值熔断器将会关闭，如果没有超即是失败率超越阈值也不会跳闸
                @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
                //时间间隔
                @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
                //失败率到达多少次后跳闸 默认50%，现在设置60，若10秒内超过10，失败率在60%以上熔断
                @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")
        }
    )
    public CommonResult paymentCircuitBreaker(@RequestParam("id")Integer id){
        log.info("id:{}正常进入服务...",id);
        if (id < 0){
            throw new RuntimeException("用户id不能为负数");
        }
        return CommonResult.success("paymentCircuitBreaker success,the user id = "+id);
    }

    public CommonResult fallBackMethodHandler(){
        log.info("fallBackMethodHandler - 降级处理");
        return CommonResult.fail("sorry,order-80-getTimeout"+ UUID.randomUUID());
    }
    public CommonResult getUserIdHandler(Integer id){
        log.info("getUserIdHandler - 降级处理");
        return CommonResult.fail("sorry,getUserIdHandler,id-"+id+" 不能为负数");
    }

    public CommonResult globalFallbackMethod(){
        return CommonResult.fail("sorry!global fallback");
    }
}
