package com.qbit.service.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author klover
 * description CodeRes
 * date 2022/10/14 13:35
 */
@Data
public class CodeRes implements Serializable {
    /**
     * 接口响应时间戳
     */
    private Integer timestamp;
    /**
     * state参数
     */
    private String state;
    /**
     * code作为换取access token的票据, code只能使用一次, 10分钟未被使用自动过期
     */
    private String code;
    /**
     * 错误原因
     */
    private String message;
}