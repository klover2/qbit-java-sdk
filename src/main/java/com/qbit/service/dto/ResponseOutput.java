package com.qbit.service.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author klover
 * description Response
 * date 2022/10/14 13:35
 */
@Data
public class ResponseOutput implements Serializable {
    private int status;
    private String reason;
    private String content;
}