package com.zyp.springcloud;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/11/25 21:26
 */
@Configuration
public class ApplicationConfig {
    @Bean
    public RouteLocator getRouteLocator(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes = builder.routes();
        RouteLocator routeLocator = routes.route("route-1", r -> r.path("/video/BV18E411x7eT?p=71")
                .uri("https://www.bilibili.com/video/BV18E411x7eT?p=71")).build();
        return routeLocator;
    }
}
