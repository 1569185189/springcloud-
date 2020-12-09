package com.zyp.springcloud.controller;

import com.zyp.springcloud.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/12/4 12:33
 */
@RestController
public class AccountController {
    @Resource
    private AccountService accountService;

    @PostMapping("/updateAccount")
    public boolean updateAccount(Long userId, BigDecimal money){
        return accountService.updateAccount(userId,money);
    }
}
