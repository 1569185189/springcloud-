package com.zyp.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/11/22 11:44
 */
@Slf4j
@RestController
@RequestMapping("/consumer/payment")
public class OrderController {

    private final static String INVOKE_URL = "http://cloud-payment-consul";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/getPaymentInfo")
    public String invokePayment(){
        return restTemplate.getForObject(INVOKE_URL+"/payment/getPaymentInfo",String.class);
    }
}
