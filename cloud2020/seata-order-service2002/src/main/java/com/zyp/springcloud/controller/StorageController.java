package com.zyp.springcloud.controller;

import com.zyp.springcloud.service.StorageSrevice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/12/4 0:02
 */
@RestController
public class StorageController {
    @Resource
    private StorageSrevice storageSrevice;

    @PostMapping("/updateStorage")
    public boolean updateStorage(Long productId, Integer count){
        return storageSrevice.updateStorage(productId,count);
    }
}
