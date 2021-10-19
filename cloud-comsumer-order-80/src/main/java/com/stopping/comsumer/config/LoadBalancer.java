package com.stopping.comsumer.config;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Description LoadBalancer
 * @Author stopping
 * @date: 2021/4/16 23:29
 */
public interface LoadBalancer {
    public ServiceInstance getServiceInstance(List<ServiceInstance> services);
}
