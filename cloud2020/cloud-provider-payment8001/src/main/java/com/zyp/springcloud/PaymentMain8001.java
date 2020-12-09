package com.zyp.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/11/19 0:08
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient  //用于向服务注册中心注册服务
public class PaymentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class,args);
    }
}
