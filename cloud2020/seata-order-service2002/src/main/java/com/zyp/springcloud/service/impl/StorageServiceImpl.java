package com.zyp.springcloud.service.impl;

import com.zyp.springcloud.dao.StorageDao;
import com.zyp.springcloud.service.StorageSrevice;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/12/3 23:57
 */
@Service
public class StorageServiceImpl implements StorageSrevice {
    @Resource
    private StorageDao StorageDao;

    @Override
    public boolean updateStorage(Long productId, Integer count) {
        return StorageDao.updateStorage(productId,count)>0;
    }
}
