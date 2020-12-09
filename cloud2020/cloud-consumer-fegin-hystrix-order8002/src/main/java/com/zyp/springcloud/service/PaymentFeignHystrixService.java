package com.zyp.springcloud.service;

import com.zyp.springcloud.service.hystrix.PaymentFallbackServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/11/22 21:23
 */

/**
 * fallback：服务降级处理类
 */
@FeignClient(value = "cloud-hystrix-payment",fallback = PaymentFallbackServiceImpl.class)
@Component
public interface PaymentFeignHystrixService {
    @GetMapping("/payment/paymentOk/{id}")
    public String paymentOk(@PathVariable("id") String id);

    @GetMapping("/payment/paymentTimeout/{id}")
    public String paymentTimeout(@PathVariable("id") String id);
}
