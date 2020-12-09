package com.zyp.springcloud.controller;

import com.zyp.springcloud.service.OpenFeignPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/11/29 16:57
 */
@RestController
@Slf4j
public class FlowLimitController {
    @Resource
    private OpenFeignPaymentService service;
    @GetMapping("/consumer/testA")
    public String testA() {
        return service.testA();
    }
}
