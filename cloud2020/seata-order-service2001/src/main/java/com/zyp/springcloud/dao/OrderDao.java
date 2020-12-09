package com.zyp.springcloud.dao;

import com.zyp.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/12/3 22:11
 */
@Mapper
public interface OrderDao {
    /**
     * 创建订单
     * @param order
     */
    int create(Order order);

    /**
     * 修改订单状态
     * @param userId 用户Id
     * @param status  订单初始状态
     */
    int updateOrderStatus(@Param("userId") Long userId, @Param("status") Integer status);

}
