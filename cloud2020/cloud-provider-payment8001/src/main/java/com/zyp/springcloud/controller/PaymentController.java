package com.zyp.springcloud.controller;

import com.zyp.springcloud.entities.CommonResult;
import com.zyp.springcloud.entities.Payment;
import com.zyp.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/11/19 21:43
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    //post请求方法参数为实体类，需加@RequestBody注解
    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        CommonResult commonResult;
        int result = paymentService.create(payment);
        log.info("*****插入数据库结果*****：{}", result);
        if (result > 0) {
            commonResult = new CommonResult(200, "插入数据库成功, serverPort: "+serverPort, result);
        } else {
            commonResult = new CommonResult(404, "插入数据库失败");
        }
        return commonResult;
    }

    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        CommonResult commonResult;
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****根据id：{}，查询结果：{}*****", id, payment);
        if (StringUtils.isEmpty(payment)) {
            commonResult = new CommonResult(404, "查询失败：id = " + id);
        } else {
            commonResult = new CommonResult(200, "查询成功, serverPort: "+serverPort, payment);
        }
        return commonResult;
    }

    @GetMapping("/discovery")
    public Object getDiscoveryClient(){
        List<String> services = discoveryClient.getServices();
        services.forEach(s->log.info("services: {}",s));
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.forEach(s->log.info("instances: {}\t{}\t{}\t{}",s.getInstanceId(),s.getHost(),s.getPort(),s.getUri()));
        return discoveryClient;
    }

    @GetMapping(value = "/lb")
    public String getPaymentLB(){
        return serverPort;
    }

    @GetMapping("/zipkin")
    public String paymentZipkin()
    {
        return "hi ,i'am paymentzipkin server fall back，welcome to atguigu，O(∩_∩)O哈哈~";
    }

    /**
     * 测试OpenFeign的超时控制
     * @return
     */
    @GetMapping("/timeout")
    public String timeoutTest(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

}
