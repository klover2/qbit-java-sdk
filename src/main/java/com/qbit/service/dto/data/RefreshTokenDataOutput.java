package com.qbit.service.dto.data;

import lombok.Data;

import java.io.Serializable;

/**
 * @author klover
 * description RefreshTokenDataOutput
 * date 2022/10/14 13:35
 */
@Data
public class RefreshTokenDataOutput implements Serializable {
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
