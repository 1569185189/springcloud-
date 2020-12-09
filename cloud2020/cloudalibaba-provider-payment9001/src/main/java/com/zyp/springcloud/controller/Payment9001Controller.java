package com.zyp.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/11/28 22:57
 */
@RestController
public class Payment9001Controller {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/nacos/payment/{id}")
    public String getPayment(@PathVariable("id") Long id) {
        return "nacos registry port: " + serverPort + " success id: " + id;
    }
}
