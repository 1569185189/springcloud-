package com.zyp.springcloud;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/11/19 22:52
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    //注释@LoadBalanced，使用自定义负载均衡策略
    //@LoadBalanced   //根据服务名负载均衡选择对应的服务
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
