package com.zyp.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/11/28 14:29
 */
@RefreshScope
@RestController
public class ConfigClient3366Controller {
    @Value("${config.info}")
    private String configInfo;

    @RequestMapping("/configInfo")
    public String getConfigInfo(){
        return configInfo;
    }
}
