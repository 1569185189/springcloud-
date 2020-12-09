package com.zyp.springcloud.service.fallback;

import com.zyp.springcloud.entities.CommonResult;
import com.zyp.springcloud.entities.Payment;
import com.zyp.springcloud.service.PaymentService;
import org.springframework.stereotype.Component;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/12/3 14:49
 */
//需要添加到spring容器中
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult paymentSQL(Long id) {
        return new CommonResult(44444,"服务降级返回,---PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}
