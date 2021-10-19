package com.stopping.cloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description CommonResult
 * @Author stopping
 * @date: 2021/4/15 11:35
 */
@Data
@NoArgsConstructor
public class CommonResult <T> implements Serializable {
    /**
     * code
     * */
    private Integer code;
    /**
     * 提示信息
     * */
    private String message;
    /**
     * 返回参数
     * */
    private T data;

    public CommonResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    /**
     * 请求成功
     * */
    public static <T>CommonResult<T> success(T t){
       return new CommonResult<>(200,"success",t);
    }
    public static <T>CommonResult<T> success(){
        return new CommonResult<>(200,"success",null);
    }
    /**
     * 请求失败
     * */
    public static <T>CommonResult<T> fail(T t){
        return new CommonResult<>(500,"request fail",t);
    }
}
