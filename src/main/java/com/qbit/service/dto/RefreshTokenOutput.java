package com.qbit.service.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author klover
 * description RefreshTokenOutput
 * date 2022/10/14 13:35
 */
@Data
public class RefreshTokenOutput implements Serializable {
    private Integer code;
    private String message;
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
}
