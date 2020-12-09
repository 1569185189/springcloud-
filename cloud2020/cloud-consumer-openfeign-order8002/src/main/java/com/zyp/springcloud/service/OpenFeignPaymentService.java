package com.zyp.springcloud.service;

import com.zyp.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/11/22 15:48
 */
@Component
@FeignClient(value = "cloud-payment-service")
public interface OpenFeignPaymentService {
    @GetMapping("/payment/get/{id}")
    CommonResult getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/payment/timeout")
    public String timeoutTest();
}
