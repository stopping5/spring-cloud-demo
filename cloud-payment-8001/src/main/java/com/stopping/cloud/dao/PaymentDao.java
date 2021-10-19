package com.stopping.cloud.dao;
import com.stopping.cloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description PaymentDao
 * @Author stopping
 * @date: 2021/4/15 11:38
 */
@Mapper
public interface PaymentDao {
    /**
     * 新增
     * */
    int create(Payment payment);
    /**
     * 查询
     * */
    Payment getPaymentById(@Param("id")Long id);
}
