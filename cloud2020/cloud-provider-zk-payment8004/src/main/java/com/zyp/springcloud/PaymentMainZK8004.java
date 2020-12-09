package com.zyp.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/11/21 21:18
 */
@SpringBootApplication
@EnableDiscoveryClient  //用于向服务注册中心注册服务
public class PaymentMainZK8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMainZK8004.class,args);
    }
}
