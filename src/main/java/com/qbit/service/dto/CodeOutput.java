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
@EqualsAndHashCode(callSuper = true)
public class CodeOutput extends Output implements Serializable {
    private CodeDataOutput data;
}