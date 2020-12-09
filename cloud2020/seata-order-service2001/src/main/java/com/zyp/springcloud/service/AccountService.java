package com.zyp.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/12/3 22:40
 */
@FeignClient("seata-account-service")
@Component   //建议加上，虽然说不加也可以
public interface AccountService {
    /**
     * 修改账户余额
     */
    @PostMapping("/updateAccount")
    boolean updateAccount(@RequestParam("userId") Long userId,@RequestParam("money") BigDecimal money);
}
