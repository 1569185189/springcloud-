package com.zyp.springcloud;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/11/22 19:10
 */
@Configuration
public class FeignConfig {
    @Bean
    public Logger.Level feginLoggerLevel(){
        return Logger.Level.FULL;
    }
}
