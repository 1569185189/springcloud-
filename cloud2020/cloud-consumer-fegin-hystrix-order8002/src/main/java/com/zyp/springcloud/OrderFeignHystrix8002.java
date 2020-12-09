package com.zyp.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/11/22 21:21
 */
@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@EnableHystrix  //开启hystrix功能
public class OrderFeignHystrix8002 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignHystrix8002.class,args);
    }
}
