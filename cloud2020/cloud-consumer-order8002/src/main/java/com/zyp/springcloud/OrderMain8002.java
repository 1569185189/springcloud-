package com.zyp.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/11/19 22:40
 */
@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MyRule.class)  //随机负载均衡策略
public class OrderMain8002 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain8002.class,args);
    }
}
