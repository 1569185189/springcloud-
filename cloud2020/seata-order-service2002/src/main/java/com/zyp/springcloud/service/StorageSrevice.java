package com.zyp.springcloud.service;

import org.apache.ibatis.annotations.Param;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/12/3 23:57
 */
public interface StorageSrevice {
    /**
     * 修改库存
     */
    boolean updateStorage(@Param("productId") Long productId,@Param("count") Integer count);
}
