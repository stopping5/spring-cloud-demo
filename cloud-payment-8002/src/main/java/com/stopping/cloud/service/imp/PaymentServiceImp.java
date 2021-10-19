package com.stopping.cloud.service.imp;

import com.stopping.cloud.dao.PaymentDao;
import com.stopping.cloud.entities.Payment;
import com.stopping.cloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description PaymentServiceImp
 * @Author stopping
 * @date: 2021/4/15 11:50
 */
@Service
public class PaymentServiceImp implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
