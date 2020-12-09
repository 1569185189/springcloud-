package com.zyp.springcloud.loadbalance.impl;

import com.zyp.springcloud.loadbalance.LoadBalance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/11/22 14:23
 */
@Component
public class MyLB implements LoadBalance {
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private int getAndIncrement() {
        int current;
        int next;
        //自旋锁和乐观锁保证数据的安全性
        do {
            current = atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        } while (!atomicInteger.compareAndSet(current, next));
        System.out.println("*******第" + next + "访问");
        return next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int count = getAndIncrement();
        int index = count % serviceInstances.size();
        //返回一个可用服务实例
        return serviceInstances.get(index);
    }
}
