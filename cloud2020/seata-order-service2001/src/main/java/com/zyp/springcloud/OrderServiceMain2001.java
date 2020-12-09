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
 * @date 2020/12/3 22:02
 */
//取消数据源自动创建的配置
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableFeignClients
@EnableDiscoveryClient
public class OrderServiceMain2001 {
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceMain2001.class,args);
    }
}
