package com.qbit.service.impl;

import com.qbit.httpclient.http.HttpRequestsBase;
import com.qbit.httpclient.util.JsonUtil;
import com.qbit.service.AuthService;
import com.qbit.service.QbitRequestService;
import com.qbit.service.dto.*;
import com.qbit.service.dto.data.ContentOutput;
import com.qbit.service.dto.data.ErrOutput;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author klover
 * description AuthServiceImpl
 * date 2022/10/14 12:59
 */
public class AuthServiceImpl implements AuthService {
    private final String clientId;
    private final String clientSecret;
    private final String baseurl;

    public AuthServiceImpl(String clientId, String clientSecret, String baseurl) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.baseurl = baseurl;
    }

    /**
     * 获取code
     *
     * @return
     */
    @Override
    public CodeOutput getCode() throws Exception {
        return this.getCode(null);
    }

    /**
     * 获取code
     *
     * @param state 重定向后会带上state参数，开发者可以填写a-zA-Z0-9的参数值，最多128字节
     * @return
     */
    @Override
    public CodeOutput getCode(String state) throws Exception {
        return this.getCode(state, null);
    }

    /**
     * 获取code
     *
     * @param state       重定向后会带上state参数，开发者可以填写a-zA-Z0-9的参数值，最多128字节
     * @param redirectUri 授权后重定向的回调链接地址， 请使用 urlEncode 对链接进行处理
     * @return
     */
    @Override
    public CodeOutput getCode(String state, String redirectUri) throws Exception {
        HttpRequestsBase service = new HttpRequestsBase.Builder().config("").build();
        String uri = this.baseurl + "/open-api/oauth/authorize";

        Map<String, Object> map = new HashMap<>(1);
        map.put("clientId", clientId);
        if (state != null && state != "") {
            map.put("state", state);
        }
        if (redirectUri != null && redirectUri != "") {
            map.put("redirectUri", redirectUri);
        }
        try {
            ResponseOutput response = service.getRequest(uri, map);
            int statusCode = response.getStatus();
            // 整理返回值
            String res = response.getContent();
            if (statusCode >= 200 && statusCode < 300) {
                return JsonUtil.toBean(res, CodeOutput.class);
            } else {
                ErrOutput err = JsonUtil.toBean(res, ErrOutput.class);
                throw new Exception(err.getMessage());
            }
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            service.close();
        }
    }

    /**
     * 获取access token
     *
     * @param code code
     * @return
     */
    @Override
    public AccessTokenOutput getAccessToken(String code) {
        HttpRequestsBase service = new HttpRequestsBase.Builder().config("").build();
        try {
            String uri = this.baseurl + "/open-api/oauth/access-token";
            HashMap<String, Object> map = new HashMap<>(3);
            map.put("clientId", clientId);
            map.put("clientSecret", clientSecret);
            map.put("code", code);
            ResponseOutput res = service.postRequest(uri, map);
            return JsonUtil.toBean(res.getContent(), AccessTokenOutput.class);
        } finally {
            service.close();
        }
    }

    /**
     * 刷新access token
     *
     * @param refreshToken 填写通过access-token获取到的refreshToken参数
     * @return
     */
    @Override
    public RefreshTokenOutput refreshToken(String refreshToken) {
        HttpRequestsBase service = new HttpRequestsBase.Builder().config("").build();
        try {
            String uri = this.baseurl + "/open-api/oauth/refresh-token";
            HashMap<String, Object> map = new HashMap<>(2);
            map.put("clientId", clientId);
            map.put("refreshToken", refreshToken);
            ResponseOutput res = service.postRequest(uri, map);
            return JsonUtil.toBean(res.getContent(), RefreshTokenOutput.class);
        } finally {
            service.close();
        }
    }
}