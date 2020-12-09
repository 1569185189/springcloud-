package com.zyp.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/11/24 22:27
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboard9001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboard9001.class,args);
    }
}
