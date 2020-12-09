package com.zyp.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/12/4 12:07
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableFeignClients
@EnableDiscoveryClient
public class AccountServiceMain2003 {
    public static void main(String[] args) {
        SpringApplication.run(AccountServiceMain2003.class,args);
    }
}
