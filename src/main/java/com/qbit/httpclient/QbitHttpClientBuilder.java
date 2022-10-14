package com.qbit.httpclient;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 * @author klover
 * description QbitHttpClientBuilder
 * date 2022/10/13 18:23
 */
public class QbitHttpClientBuilder extends HttpClientBuilder {
    private QbitHttpClientBuilder() {
        super();
    }

    public static QbitHttpClientBuilder create() {
        return new QbitHttpClientBuilder();
    }

    @Override
    public CloseableHttpClient build() {
        return super.build();
    }
}