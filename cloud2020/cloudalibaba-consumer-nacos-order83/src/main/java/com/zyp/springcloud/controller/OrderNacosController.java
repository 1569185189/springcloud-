package com.zyp.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/11/29 10:21
 */
@RestController
public class OrderNacosController {
    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String urlPath;

    @GetMapping("/consumer/nacos/payment/{id}")
    public String getConsumerPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(urlPath+"/nacos/payment/"+id,String.class);
    }
}
