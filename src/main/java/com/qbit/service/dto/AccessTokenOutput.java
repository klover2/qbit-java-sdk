package com.qbit.service.dto;

import com.qbit.service.dto.data.AccessTokenDataOutput;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author klover
 * description AccessTokenOutput
 * date 2022/10/14 14:17
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AccessTokenOutput extends Output implements Serializable {
    private AccessTokenDataOutput data;
}