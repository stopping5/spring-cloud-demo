package com.stopping.cloud.service;

import com.stopping.cloud.entities.Payment;

/**
 * @Description PaymentService
 * @Author stopping
 * @date: 2021/4/15 11:48
 */

public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(Long id);
}
