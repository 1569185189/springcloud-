package com.zyp.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/11/29 16:55
 */
@EnableDiscoveryClient
@SpringBootApplication
public class SentinelMain8401 {
    public static void main(String[] args) {
        SpringApplication.run(SentinelMain8401.class,args);
    }
}
