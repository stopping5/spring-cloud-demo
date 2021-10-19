package com.stopping.comsumer.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description MySelfRule
 * @Author stopping
 * @date: 2021/4/16 19:56
 */
@Component
@Slf4j
public class MySelfRule implements LoadBalancer{

    private AtomicInteger nextIndexInteger = new AtomicInteger(0);

    @Override
    public ServiceInstance getServiceInstance(List<ServiceInstance> services) {
        if (services == null || services.size() == 0){
            log.info("getServiceInstance File!!!");
            return null;
        }
        //所有的服务总数
        ServiceInstance serviceInstance = null;
        int count = 0;
        while (serviceInstance == null && count++ < 10){
            Integer allService = services.size();
            int next = incIndex(allService);
            log.info("allService:{} ,next index : {}",allService,next);
            serviceInstance = services.get(next);
            return serviceInstance;
        }
        return serviceInstance;
    }

    private final int incIndex(Integer allService) {
        for(;;){
            Integer current = nextIndexInteger.get();
            Integer next = (current + 1) % allService;
            log.info("current:{},next:{}",current,next);
            nextIndexInteger.compareAndSet(current,next);
            return next;
        }
    }
}
