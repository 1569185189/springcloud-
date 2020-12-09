package com.zyp.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/12/3 22:03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T object;

    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
}
