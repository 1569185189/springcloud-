package com.zyp.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/12/3 13:14
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Payment9003 {
    public static void main(String[] args) {
        SpringApplication.run(Payment9003.class,args);
    }
}
