package com.zyp.springcloud.service.hystrix;

import com.zyp.springcloud.service.PaymentFeignHystrixService;
import org.springframework.stereotype.Component;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/11/23 8:59
 */
@Component  //此注解不能少
public class PaymentFallbackServiceImpl implements PaymentFeignHystrixService {
    @Override
    public String paymentOk(String id) {
        return "paymentOk：服务异常，请稍后再试/系统故障";
    }

    @Override
    public String paymentTimeout(String id) {
        return "paymentTimeout：服务异常，请稍后再试/系统故障";
    }
}
