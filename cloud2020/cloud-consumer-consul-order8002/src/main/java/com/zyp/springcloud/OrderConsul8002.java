package com.zyp.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/11/22 11:43
 */
@SpringBootApplication
@EnableDiscoveryClient  //向注册中心注册服务
public class OrderConsul8002 {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsul8002.class,args);
    }
}
