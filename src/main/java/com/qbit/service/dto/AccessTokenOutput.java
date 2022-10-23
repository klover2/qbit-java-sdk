package com.qbit.service.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author klover
 * description AccessTokenOutput
 * date 2022/10/14 14:17
 */
@Data
public class AccessTokenOutput implements Serializable {
    private Integer code;
    private String message;
    /**
     * 接口调用凭证
     */
    private String accessToken;
    /**
     * 刷新accessToken(有效期为30天，当refresh token失效之后，需要重新授权)
     */
    private String refreshToken;
    /**
     * 凭证有效时间，单位：秒
     */
    private Integer expiresIn;
    /**
     * 接口响应时间戳
     */
    private Integer timestamp;
}