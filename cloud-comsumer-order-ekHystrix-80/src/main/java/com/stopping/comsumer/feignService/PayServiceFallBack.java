package com.stopping.comsumer.feignService;

import com.stopping.cloud.entities.CommonResult;
import org.springframework.stereotype.Component;

/**
 * @Description PayServiceFallBack
 * @Author stopping
 * @date: 2021/4/17 18:01
 */
@Component
public class PayServiceFallBack implements PayServiceFeign{
    @Override
    public CommonResult requestOk() {
        return CommonResult.fail("PayServiceFallBack --- requestOk");
    }

    @Override
    public CommonResult requestTimeout() {
        return CommonResult.fail("PayServiceFallBack --- requestTimeout");
    }
}
