package com.zyp.springcloud.service.impl;

import com.zyp.springcloud.dao.OrderDao;
import com.zyp.springcloud.domain.Order;
import com.zyp.springcloud.service.AccountService;
import com.zyp.springcloud.service.OrderService;
import com.zyp.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/12/3 22:48
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private AccountService accountService;

    @Resource
    private StorageService storageService;

    @Override
    public boolean create(Order order) {
        return orderDao.create(order) > 0;
    }

    @Override
    public boolean updateOrderStatus(Long userId, Integer status) {
        return orderDao.updateOrderStatus(userId, status) > 0;
    }

    @Override
    @GlobalTransactional(name = "tx_seata_first_test",rollbackFor = Exception.class)
    public boolean buy(Order order) {
        log.info("订单信息开始生成");
        boolean flagOne = create(order);
        log.info("订单信息已生成");

        judgeFlag(flagOne);

        log.info("开始修改库存");
        boolean flagTwo = storageService.updateStorage(order.getProductId(), order.getCount());
        log.info("已修改库存");

        judgeFlag(flagTwo);

        log.info("开始修改账户金额");
        boolean flagThree = accountService.updateAccount(order.getUserId(), order.getMoney());
        log.info("已修改账户金额");

        judgeFlag(flagThree);

        log.info("开始修改订单状态");
        boolean flagFour = updateOrderStatus(order.getUserId(), order.getStatus());
        log.info("已修改订单状态");

        judgeFlag(flagFour);

        return true;
    }

    /**
     * 判断操作是否成功
     * @param flag 判断标志
     */
    private static void judgeFlag(boolean flag) {
        if (!flag) {
            throw new RuntimeException("下单失败，请重试");
        }
    }
}
