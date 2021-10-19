package com.stopping.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

import javax.swing.*;

/**
 * @Description Dashboard9001
 * @Author stopping
 * @date: 2021/4/17 23:21
 */
@SpringBootApplication
@EnableHystrixDashboard
@EnableTurbine
//http://localhost:9001/hystrix
public class Dashboard9001 {
    public static void main(String[] args) {
        SpringApplication.run(Dashboard9001.class,args);
    }
}
