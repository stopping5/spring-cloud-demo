package com.stopping.clou.controller;

import com.stopping.clou.service.IMessageProvider;
import com.stopping.clou.service.imp.RabbitProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description MessageProviderController
 * @Author stopping
 * @date: 2021/4/20 16:27
 */
@RestController
public class MessageProviderController {
    @Resource
    private IMessageProvider iMessageProvider;

    @GetMapping("/send")
    public String send(){
        iMessageProvider.send();
        return "send message success";
    }
}
