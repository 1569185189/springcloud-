package com.zyp.springcloud.controller;

import com.zyp.springcloud.entities.CommonResult;
import com.zyp.springcloud.service.OpenFeignPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/11/22 15:46
 */
@RestController
@Slf4j
@RequestMapping("/consumer/payment")
public class OrderOpenFeign8002Controller {
    @Resource
    private OpenFeignPaymentService paymentService;

    @GetMapping("/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id){
        return paymentService.getPaymentById(id);
    }
    @GetMapping("/timeout")
    public String timeoutTest(){
        return paymentService.timeoutTest();
    }
}
