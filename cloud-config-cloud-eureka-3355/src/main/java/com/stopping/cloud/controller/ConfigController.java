package com.stopping.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description ConfigController
 * @Author stopping
 * @date: 2021/4/19 17:36
 */
@RestController
@RefreshScope
public class ConfigController {
    @Value("${info}")
    private String info;

    @GetMapping("/getInfo")
    public String getConfigInfo(){
        return info;
    }
}
