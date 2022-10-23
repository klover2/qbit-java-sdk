package com.qbit.service.dto.data;

import lombok.Data;

import java.io.Serializable;

/**
 * @author klover
 * description 返回
 * date 2022/10/14 13:35
 */
@Data
public class ContentOutput implements Serializable {
    private Integer code;
    private String message;
    private Object data;
}
