package com.stopping.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description ConfigController
 * @Author stopping
 * @date: 2021/4/22 16:42
 */
@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {
    @Value("${config.info}")
    private String info;

    @GetMapping("/get")
    public String getConfig(){
        return info;
    }
}
