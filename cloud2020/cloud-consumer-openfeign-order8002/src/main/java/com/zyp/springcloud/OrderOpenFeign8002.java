package com.zyp.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/11/22 15:43
 */
@SpringBootApplication
@EnableFeignClients //开启OpenFeign功能
public class OrderOpenFeign8002 {
    public static void main(String[] args) {
        SpringApplication.run(OrderOpenFeign8002.class,args);
    }
}
