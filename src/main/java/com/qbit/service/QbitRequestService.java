package com.qbit.service;

import com.qbit.httpclient.QbitHttpClientBuilder;
import com.qbit.service.dto.Output;
import com.qbit.service.impl.QbitRequestServiceImpl;
import org.apache.http.impl.client.CloseableHttpClient;

import java.util.Map;

/**
 * @author klover
 * description QbitRequestService
 * date 2022/10/14 12:18
 */
public interface QbitRequestService {
    /**
     * Service构造器
     */
    class Builder {
        private CloseableHttpClient httpClient;
        private String accessToken;

        /**
         * 设置请求配置，以该配置构造默认的httpClient，若未调用httpClient()方法，则必须调用该方法
         *
         * @param accessToken access_token
         * @return Builder
         */
        public Builder config(String accessToken) {
            this.httpClient = QbitHttpClientBuilder.create().build();
            this.accessToken = accessToken;
            return this;
        }

        /**
         * 构造服务
         *
         * @return QbitService
         */
        public QbitRequestService build() {
            return new QbitRequestServiceImpl(httpClient, accessToken);
        }
    }

    /**
     * post 请求
     *
     * @param url    url
     * @param params 参数
     * @return String
     */

    Output postRequest(String url, Map<String, Object> params);

    /**
     * put 请求
     *
     * @param url    url
     * @param params 参数
     * @return String
     */

    Output putRequest(String url, Map<String, Object> params);

    /**
     * delete 请求
     *
     * @param url    url
     * @param params 参数
     * @return String
     */

    Output deleteRequest(String url, Map<String, Object> params);

    /**
     * get 请求
     *
     * @param url url
     * @return String
     */
    Output getRequest(String url);

    /**
     * get 请求
     *
     * @param url   url
     * @param query 参数
     * @return String
     */
    Output getRequest(String url, Map<String, Object> query);

    /**
     * 关闭流请求
     */
    void close();
}
