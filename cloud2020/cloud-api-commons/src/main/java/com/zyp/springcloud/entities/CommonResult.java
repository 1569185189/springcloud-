package com.zyp.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/11/19 21:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;
    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
}
