package com.zyp.springcloud.controller;

import com.zyp.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/11/22 19:59
 */
@RestController
@Slf4j
public class PaymentHystrixController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/paymentOk/{id}")
    public String payment_ok(@PathVariable("id") String id){
        return paymentService.paymentOk(id)+", port: "+serverPort;
    }

    @GetMapping("/payment/paymentTimeout/{id}")
    public String payment_timeout(@PathVariable("id") String id){
        return paymentService.paymentTimeout(id)+", port: "+serverPort;
    }

    //===服务熔断
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("*******result:"+result);
        return result;
    }
}
