package com.zyp.springcloud.loadbalance;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/11/22 14:19
 */
public interface LoadBalance {
    /**
     * 收集服务器可用服务
     * @param serviceInstances
     * @return
     */
    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
