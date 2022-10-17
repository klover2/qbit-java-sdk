package com.qbit.service.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author klover
 * description 错误返回
 * date 2022/10/14 13:35
 */
@Data
public class ErrOutput implements Serializable {
    /**
     * 错误码
     */
    private Integer code;
    /**
     * 错误原因
     */
    private String message;
}
