package com.zyp.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/11/22 11:27
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/getPaymentInfo")
    public String getPaymentInfo(){
        return "This info from the server port: "+serverPort+", UUID: "+
                UUID.randomUUID().toString();
    }


}
