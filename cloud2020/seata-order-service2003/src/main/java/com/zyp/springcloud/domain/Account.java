package com.zyp.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/12/4 12:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private Long id;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 总额度
     */
    private BigDecimal total;
    /**
     * 已用余额
     */
    private BigDecimal used;
    /**
     * 剩余可用额度
     */
    private BigDecimal residue;
}
