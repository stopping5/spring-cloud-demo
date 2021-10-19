package com.stopping.cloud.entities;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description Payment
 * @Author stopping
 * @date: 2021/4/15 11:33
 */
@Data
public class Payment implements Serializable {
    /**
     * id
     * */
    private Long id;
    /**
     * 序列化
     * */
    private String serial;
}
