package com.qbit.httpclient.dto;

import org.apache.http.client.methods.HttpRequestWrapper;

import java.io.IOException;

/**
 * @author klover
 * description CredentialsDto
 * date 2022/10/13 18:53
 */
public interface CredentialsDto {
    /**
     * 获取code
     * @param request HttpRequestWrapper
     * @return String
     */
    String getCode(HttpRequestWrapper request) throws IOException;
}
