package com.zyp.springcloud.service;

import java.math.BigDecimal;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/12/4 12:29
 */
public interface AccountService {
    /**
     * 修改账户余额
     *
     * @param userId 用户Id
     * @param money  使用金额
     * @return
     */
    boolean updateAccount(Long userId, BigDecimal money);
}
