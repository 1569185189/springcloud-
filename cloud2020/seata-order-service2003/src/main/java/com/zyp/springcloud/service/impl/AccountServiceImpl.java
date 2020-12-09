package com.zyp.springcloud.service.impl;

import com.zyp.springcloud.dao.AccountDao;
import com.zyp.springcloud.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/12/4 12:30
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountDao accountDao;

    @Override
    public boolean updateAccount(Long userId, BigDecimal money) {
        return accountDao.updateAccount(userId,money)>0;
    }
}
