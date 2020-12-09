package com.zyp.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/11/29 16:55
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class SentinelMain8402 {
    public static void main(String[] args) {
        SpringApplication.run(SentinelMain8402.class,args);
    }
}
