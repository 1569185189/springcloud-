package com.zyp.springcloud.service;

import com.zyp.springcloud.entities.Payment;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/11/19 21:36
 */
public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(Long id);
}
