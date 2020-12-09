package com.zyp.springcloud.service;

import com.zyp.springcloud.domain.Order;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/12/3 22:39
 */
public interface OrderService {
    /**
     * 创建订单
     * @param order
     */
    boolean create(Order order);

    /**
     * 修改订单状态
     * @param userId 订单id
     * @param status  订单初始状态
     */
    boolean updateOrderStatus(Long userId, Integer status);

    /**
     * 购物
     * @param order
     */
    boolean buy(Order order);
}
