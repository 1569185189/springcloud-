package com.zyp.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zyp.springcloud.entities.CommonResult;
import com.zyp.springcloud.entities.Payment;
import com.zyp.springcloud.myhandler.CustomerHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/12/3 12:33
 */
@RestController
public class RateLimitController {
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "blockHandlerMethod")
    public CommonResult byResource(){
        return new CommonResult(200,"按资源名称限流OK",new Payment(1L,"asdhjkas"));
    }

    public CommonResult blockHandlerMethod(BlockException exception){
        return new CommonResult(400,"服务不可用");
    }

    @GetMapping("/byUrl")
    @SentinelResource(value = "byUrl", blockHandler = "blockHandlerMethod")
    public CommonResult byUrl(){
        return new CommonResult(200,"按url限流OK",new Payment(2L,"sdasdqw"));
    }

    @GetMapping(value = "/byHandlerClass")
    @SentinelResource(value = "byHandlerClass",
            blockHandlerClass = CustomerHandler.class,
            blockHandler = "handlerExecption2")
    public CommonResult byHandlerClass(){
        return new CommonResult(200,"兜底的处理类处理限流OK",new Payment(2020L,"asdqwe"));
    }
}
