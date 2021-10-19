package com.stopping.clou.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @Description RecMsgController
 * @Author stopping
 * @date: 2021/4/20 16:51
 */
@Component
@EnableBinding(Sink.class)
public class RecMsgController {
    @Value("${server.port}")
    private String port;
    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        System.out.println(port + "接受消息:"+message.getPayload());
    }
}
