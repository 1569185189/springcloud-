package com.zyp.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/11/22 15:48
 */
@Component
@FeignClient(value = "cloudalibaba-sentinel-service")
public interface OpenFeignPaymentService {

    @GetMapping("/testA")
    public String testA();
}
