package com.zyp.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/11/21 22:06
 */
@SpringBootApplication
@EnableDiscoveryClient  //用于向服务注册中心注册服务
public class OrderZKMain8002 {
    public static void main(String[] args) {
        SpringApplication.run(OrderZKMain8002.class,args);
    }
}
