package com.zyp.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/12/3 23:46
 */
@Mapper
public interface StorageDao {
    /**
     * 修改库存
     */
    int updateStorage(@Param("productId") Long productId, @Param("count") Integer count);
}
