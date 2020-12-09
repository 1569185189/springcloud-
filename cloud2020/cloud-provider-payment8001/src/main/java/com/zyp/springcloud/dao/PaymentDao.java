package com.zyp.springcloud.dao;

import com.zyp.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/11/19 21:17
 */
@Mapper //推荐
//@Repository //不推荐
public interface PaymentDao {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
