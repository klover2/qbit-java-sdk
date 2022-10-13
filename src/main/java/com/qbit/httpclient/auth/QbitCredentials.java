package com.qbit.httpclient.auth;

import com.qbit.httpclient.dto.CredentialsDto;
import org.apache.http.client.methods.HttpRequestWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Serializable;

/**
 * @author klover
 * @description QbitCredentials
 * @date 2022/10/13 18:46
 */
public class QbitCredentials implements CredentialsDto {
    protected final String clientId;
    protected final String clientSecret;
    protected final String baseUrl;
    protected static final Logger log = LoggerFactory.getLogger(QbitCredentials.class);

    public QbitCredentials(String clientId, String clientSecret, String baseUrl) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.baseUrl = baseUrl;
    }

    /**
     * 获取code
     *
     * @param request HttpRequestWrapper
     * @return String
     */
    @Override
    public final String getCode(HttpRequestWrapper request) throws IOException {
        return null;
    }
}