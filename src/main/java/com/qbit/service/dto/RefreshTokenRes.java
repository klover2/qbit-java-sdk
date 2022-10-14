package com.qbit.service.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author klover
 * description CodeRes
 * date 2022/10/14 13:35
 */
@Data
public class RefreshTokenRes implements Serializable {
    /**
     * 接口调用凭证
     */
    private String accessToken;
    /**
     * 凭证有效时间，单位：秒
     */
    private Integer expiresIn;
    /**
     * 接口响应时间戳
     */
    private Integer timestamp;
    /**
     * 错误码
     */
    private String code;
    /**
     * 错误原因
     */
    private String message;
}
