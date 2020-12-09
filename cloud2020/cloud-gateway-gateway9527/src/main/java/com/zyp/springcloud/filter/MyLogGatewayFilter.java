package com.zyp.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/11/25 23:46
 */
@Component
@Slf4j
public class MyLogGatewayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("*******coming in");
        ServerHttpRequest request = exchange.getRequest();
        String username = request.getQueryParams().getFirst("username");
        if (StringUtils.isEmpty(username)){
            log.info("用户名非法");
            //返回响应
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    //过滤器执行的优先级，值越小优先级越高
    @Override
    public int getOrder() {
        return -1;
    }
}
