package com.qbit.service.dto;

import com.qbit.service.dto.data.CodeDataOutput;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author klover
 * description CodeOutput
 * date 2022/10/14 13:35
 */
@Data
public class CodeOutput implements Serializable {
    private int status;
    private CodeDataOutput data;
    private ErrOutput err;
}