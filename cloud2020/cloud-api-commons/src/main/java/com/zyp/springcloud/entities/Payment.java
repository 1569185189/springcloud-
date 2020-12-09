package com.zyp.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/11/19 21:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Payment implements Serializable {
    private Long id;
    private String serial;
}
