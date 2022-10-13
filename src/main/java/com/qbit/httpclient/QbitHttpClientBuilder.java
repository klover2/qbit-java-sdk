package com.qbit.httpclient;

import com.qbit.httpclient.auth.QbitCredentials;
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
    private final String API_BASEURL = "https://api-global.qbitnetwork.com/";

    private QbitHttpClientBuilder() {
        super();
    }

    public static QbitHttpClientBuilder create() {
        return new QbitHttpClientBuilder();
    }

    /**
     * 商户配置
     *
     * @param clientId     client id
     * @param clientSecret secret
     * @param baseUrl      运行环境,不填默认生产
     * @return
     */
    public QbitHttpClientBuilder withMerchant(String clientId, String clientSecret, String baseUrl) {
        QbitCredentials credentials = new QbitCredentials(clientId, clientSecret, baseUrl);
        return this;
    }

    /**
     * 商户配置
     *
     * @param clientId     client id
     * @param clientSecret secret
     * @return
     */
    public QbitHttpClientBuilder withMerchant(String clientId, String clientSecret) {
        QbitCredentials credentials = new QbitCredentials(clientId, clientSecret, API_BASEURL);
        return this;
    }

    @Override
    public CloseableHttpClient build() {
        return super.build();
    }
}