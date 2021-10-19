package com.stopping.clou.service.imp;

import com.stopping.clou.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.integration.support.MessageBuilder;
import javax.annotation.Resource;
import org.springframework.cloud.stream.messaging.Source;
import java.util.UUID;

/**
 * @Description RabbitProvider
 * @Author stopping
 * @date: 2021/4/20 16:22
 */
@EnableBinding(Source.class)
public class RabbitProvider implements IMessageProvider {

    @Resource
    //这里一定要用output为bean name
    private MessageChannel output;

    @Override
    public void send() {
        String serial = UUID.randomUUID().toString();
        output.send(
                MessageBuilder.withPayload(serial).build()
        );
        System.out.println("send message :"+serial);
    }
}
