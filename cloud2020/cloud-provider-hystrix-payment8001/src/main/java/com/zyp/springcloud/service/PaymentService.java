package com.zyp.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/11/22 19:56
 */
@Service
public class PaymentService {
    public String paymentOk(String id) {
        return "当前线程：" + Thread.currentThread().getName() + "paymentOk id: " + id + ", UUID: " + UUID.randomUUID();
    }

    /**
     * fallbackMethod: 服务降级的处理方式
     * commandProperties：触发服务降级的条件
     */
    @HystrixCommand(fallbackMethod = "paymentTimeoutHandle",commandProperties = @HystrixProperty(
        name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000"
    ))
    public String paymentTimeout(String id) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //int i = 10/0;
        return "当前线程：" + Thread.currentThread().getName() + "paymentTimeout id: " + id + " takes n seconds" + ", UUID: " + UUID.randomUUID();
    }

    public String paymentTimeoutHandle(String id) {
        return "当前线程：" + Thread.currentThread().getName() + "服务繁忙，请稍后再试/服务异常 id: " + id + ", UUID: " + UUID.randomUUID();
    }
    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback",
    commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), //失败率达到多少后触发熔断
    })
    public String paymentCircuitBreaker(Integer id){
        if (id<0){
            throw new RuntimeException("*****id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号："+serialNumber;
    }

    public String paymentCircuitBreakerFallback(Integer id){
        return "id 不能为负数，请稍后再试 id: "+id;
    }
    //服务熔断
    /*@HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),   //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),  //时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), //失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if (id < 0){
            throw new RuntimeException("*****id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功,流水号："+serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能负数，请稍候再试,(┬＿┬)/~~     id: " +id;
    }*/
}
