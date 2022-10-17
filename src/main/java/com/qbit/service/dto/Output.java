package com.qbit.service.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author klover
 * description 返回
 * date 2022/10/14 13:35
 */
@Data
public class Output implements Serializable {
    private int status;
    private Object data;
    private ErrOutput err;
}
