package com.zyp.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/12/3 22:40
 */
@FeignClient("seata-storage-service")
@Component
public interface StorageService {
    /**
     * 修改库存
     */
    @PostMapping("/updateStorage")
    boolean updateStorage(@RequestParam("productId") Long productId,@RequestParam("count") Integer count);
}
