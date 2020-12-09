package com.zyp.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zyp.springcloud.service.PaymentFeignHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/11/22 21:25
 */
@RestController
@Slf4j
//定义全局的服务降级处理方式
@DefaultProperties(defaultFallback = "globalHystrixHandle")
public class OrderFeignHystrixController {
    @Resource
    private PaymentFeignHystrixService paymentService;

    @GetMapping("/consumer/payment/paymentOk/{id}")
    public String paymentOk(@PathVariable("id") String id) {
        return paymentService.paymentOk(id);
    }

    /**
     * fallbackMethod：服务降级的处理方法
     * commandProperties：触发服务降级的条件
     */
    //有自定义的服务降级处理，使用自定义的处理方式
    @HystrixCommand(fallbackMethod = "paymentTimeoutHandle", commandProperties = @HystrixProperty(
            name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500"
    ))
    @GetMapping("/consumer/payment/paymentTimeout/{id}")
    public String paymentTimeout(@PathVariable("id") String id) {
        int i = 10 / 0;
        return paymentService.paymentTimeout(id);
    }

    //没有默认的服务降级处理，使用全局的降级处理方式
    @GetMapping("/consumer/handle/{id}")
    @HystrixCommand
    public String testGlobalHandle(@PathVariable("id") String id) {
        System.out.println(id);
        int i = 10 / 0;
        return "test globalHystrixHandle";
    }

    public String paymentTimeoutHandle(String id) {
        return "当前线程：" + Thread.currentThread().getName() + "服务繁忙，请稍后再试/服务异常 id: " + id + ", UUID: " + UUID.randomUUID();
    }

    public String globalHystrixHandle() {
        return "globalHystrixHandle 服务降级处理";
    }
}
