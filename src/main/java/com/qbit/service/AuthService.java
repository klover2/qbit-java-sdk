package com.qbit.service;

import com.qbit.service.dto.AccessTokenRes;
import com.qbit.service.dto.CodeRes;
import com.qbit.service.impl.AuthServiceImpl;

/**
 * @author klover
 * description AuthService
 * date 2022/10/14 12:54
 */
public interface AuthService {
    /**
     * Service构造器
     */
    class Builder {
        private String clientId;
        private String clientSecret;
        private String baseurl;

        /**
         * 配置
         *
         * @param clientId     clientId
         * @param clientSecret clientSecret
         * @param baseurl      baseurl
         * @return
         */
        public AuthService.Builder config(String clientId, String clientSecret, String baseurl) {
            this.clientId = clientId;
            this.clientSecret = clientSecret;
            this.baseurl = baseurl;

            return this;
        }

        /**
         * 构造服务
         *
         * @return QbitService
         */
        public AuthService build() {
            return new AuthServiceImpl(clientId, clientSecret, baseurl);
        }
    }

    /**
     * 获取code
     *
     * @return
     */
    CodeRes getCode();

    /**
     * 获取code
     *
     * @param state 重定向后会带上state参数，开发者可以填写a-zA-Z0-9的参数值，最多128字节
     * @return
     */
    CodeRes getCode(String state);

    /**
     * 获取code
     *
     * @param state       重定向后会带上state参数，开发者可以填写a-zA-Z0-9的参数值，最多128字节
     * @param redirectUri 授权后重定向的回调链接地址， 请使用 urlEncode 对链接进行处理
     * @return
     */
    CodeRes getCode(String state, String redirectUri);

    /**
     * 获取access token
     *
     * @param code code
     * @return
     */
    AccessTokenRes getAccessToken(String code);
}
