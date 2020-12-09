package com.zyp.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/12/4 12:16
 */
@Mapper
public interface AccountDao {
    /**
     * 修改账户余额
     * @param userId 用户Id
     * @param money 使用金额
     * @return
     */
    int updateAccount(@Param("userId") Long userId,@Param("money") BigDecimal money);
}
