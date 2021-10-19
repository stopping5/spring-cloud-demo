package com.stopping.comsumer.feignService;

import com.stopping.cloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description PayServiceFeign
 * @Author stopping
 * @date: 2021/4/17 16:35
 */
@Component
@FeignClient(value = "cloud-payment-service",fallback = PayServiceFallBack.class)
public interface PayServiceFeign {
    @GetMapping("/payment/getOk")
    CommonResult requestOk();

    @GetMapping("/payment/getTimeout")
    CommonResult requestTimeout();
}
