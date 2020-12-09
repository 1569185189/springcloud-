package com.zyp.springcloud.controller;

import com.zyp.springcloud.domain.CommonResult;
import com.zyp.springcloud.domain.Order;
import com.zyp.springcloud.service.OrderService;
import com.zyp.springcloud.service.StorageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/12/3 23:04
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @Resource
    private StorageService storageService;

    /**
     * 方便测试使用get请求
     */
    @GetMapping("/order")
    public CommonResult Order(Order order){
        boolean buy = orderService.buy(order);
        if (!buy){
            return new CommonResult(400,"下单失败，请重试");
        }
        return new CommonResult(200,"下单成功");
    }

    @GetMapping("/updateStorage")
    public CommonResult updateStorage(Long productId,Integer count){
        boolean storage = storageService.updateStorage(productId, count);
        if(!storage){
            return new CommonResult(400,"测试失败");
        }
        return new CommonResult(200,"测试成功");
    }
}
