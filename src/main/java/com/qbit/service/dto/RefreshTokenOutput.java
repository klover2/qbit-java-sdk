package com.qbit.service.dto;

import com.qbit.service.dto.data.RefreshTokenDataOutput;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author klover
 * description RefreshTokenOutput
 * date 2022/10/14 13:35
 */
@Data
public class RefreshTokenOutput implements Serializable {
    private int status;
    private RefreshTokenDataOutput data;
    private ErrOutput err;
}
