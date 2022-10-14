package com.qbit.httpclient;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 * @author klover
 * description QbitHttpClientBuilder
 * date 2022/10/13 18:23
 */
public class QbitHttpClientBuilder extends HttpClientBuilder {
    private static final String OS = System.getProperty("os.name") + "/" + System.getProperty("os.version");
    private static final String VERSION = System.getProperty("java.version");

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