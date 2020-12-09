package com.zyp.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/11/22 13:50
 */

/**
 * 替换默认的负载均衡策略，采用随机的策略
 * 如果需要定制化，则该类不应该被@ComponentScan扫描到
 * 否则该策略会被所有的Ribbon客户端所共享
 */
@Configuration
public class MyRule {
    @Bean
    public IRule getRandomRule(){
        return new RandomRule();
    }
}
