package com.zyp.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/12/3 10:36
 */
@RestController
public class FlowLimitTwoController {
    @GetMapping("/testHotkey")
    @SentinelResource(value = "testHotkey",blockHandler = "blockHandlerMethod") //热点key限流注解
    public String testHotKey(@RequestParam(value = "k1",required = false) String k1,
                             @RequestParam(value = "k2",required = false) String k2){
        int i = 10/0;
        return "-----------testHotkey";
    }

    //兜底方法(BlockException exception参数不能少)
    public String blockHandlerMethod(String p1, String p2, BlockException exception){
        return "-------------blockHandlerMethod";
    }
}
