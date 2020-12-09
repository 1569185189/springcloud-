package com.zyp.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zyp.springcloud.entities.CommonResult;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/12/3 12:55
 */
public class CustomerHandler {
    public static CommonResult handlerExecption1(BlockException execption){
        return new CommonResult(400,"自定义异常处理类，handlerExecption1");
    }

    public static CommonResult handlerExecption2(BlockException execption){
        return new CommonResult(400,"自定义异常处理类，handlerExecption2");
    }
}
