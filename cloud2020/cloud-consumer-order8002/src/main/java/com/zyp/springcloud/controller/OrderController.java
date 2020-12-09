package com.zyp.springcloud.controller;

import com.zyp.springcloud.entities.CommonResult;
import com.zyp.springcloud.entities.Payment;
import com.zyp.springcloud.loadbalance.LoadBalance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/11/19 22:43
 */
@RestController
@RequestMapping("/consumer/payment")
@Slf4j
public class OrderController {
    private final static String PATH_URL = "http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalance loadBalance;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/create")
    public CommonResult create(Payment payment){
        //发送POST请求调用远程接口
        return restTemplate.postForObject(PATH_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        //发送GET请求调用远程接口
        return restTemplate.getForObject(PATH_URL+"/payment/get/"+id,CommonResult.class);
    }

    @GetMapping("/getEntity/{id}")
    public CommonResult getEntity(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> templateForEntity = restTemplate.getForEntity(PATH_URL + "/payment/get/" + id, CommonResult.class);
        CommonResult body = templateForEntity.getBody();
        boolean xxSuccessful = templateForEntity.getStatusCode().is2xxSuccessful();
        if (xxSuccessful){
            log.info("Headers: {}",templateForEntity.getHeaders());
            log.info("StatusCodeValue: {}",templateForEntity.getStatusCodeValue());
        }
        return body;
    }
    // ====================> zipkin+sleuth
    @GetMapping("/zipkin")
    public String paymentZipkin()
    {
        String result = restTemplate.getForObject("http://localhost:8001"+"/payment/zipkin/", String.class);
        return result;
    }

    @GetMapping("/lb")
    public String getPaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        //返回单个服务实例
        ServiceInstance serviceInstance = loadBalance.instance(instances);
        log.info("***********Uri: {}",serviceInstance.getUri());
        return restTemplate.getForObject(serviceInstance.getUri()+"/payment/lb",String.class);
    }
}
