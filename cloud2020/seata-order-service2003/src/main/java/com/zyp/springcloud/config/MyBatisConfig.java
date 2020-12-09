package com.zyp.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/12/3 23:23
 */
@Component
@MapperScan("com.zyp.springcloud.dao")
public class MyBatisConfig {
}
