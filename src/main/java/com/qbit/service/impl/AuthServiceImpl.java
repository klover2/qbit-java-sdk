package com.qbit.service.impl;

import com.qbit.httpclient.util.JsonUtil;
import com.qbit.service.AuthService;
import com.qbit.service.QbitRequestService;
import com.qbit.service.dto.AccessTokenRes;
import com.qbit.service.dto.CodeRes;
import com.qbit.service.dto.RefreshTokenRes;

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
    public CodeRes getCode() {
        return this.getCode(null);
    }

    /**
     * 获取code
     *
     * @param state 重定向后会带上state参数，开发者可以填写a-zA-Z0-9的参数值，最多128字节
     * @return
     */
    @Override
    public CodeRes getCode(String state) {
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
    public CodeRes getCode(String state, String redirectUri) {
        QbitRequestService service = new QbitRequestService.Builder().config("").build();
        String uri = this.baseurl + "/open-api/oauth/authorize";

        Map<String, String> map = new HashMap<>(1);
        map.put("clientId", clientId);
        if (state != null && state != "") {
            map.put("state", state);
        }
        if (redirectUri != null && redirectUri != "") {
            map.put("redirectUri", redirectUri);
        }
        String res = service.getRequest(uri, map);
        service.close();
        return JsonUtil.toBean(res, CodeRes.class);
    }

    /**
     * 获取access token
     *
     * @param code code
     * @return
     */
    @Override
    public AccessTokenRes getAccessToken(String code) {
        String uri = this.baseurl + "/open-api/oauth/access-token";
        QbitRequestService service = new QbitRequestService.Builder().config("").build();
        HashMap<String, Object> map = new HashMap<>(3);
        map.put("clientId", clientId);
        map.put("clientSecret", clientSecret);
        map.put("code", code);
        String res = service.postRequest(uri, map);
        service.close();
        return JsonUtil.toBean(res, AccessTokenRes.class);
    }

    /**
     * 刷新access token
     *
     * @param refreshToken 填写通过access-token获取到的refreshToken参数
     * @return
     */
    @Override
    public RefreshTokenRes refreshToken(String refreshToken) {
        String uri = this.baseurl + "/open-api/oauth/refresh-token";
        QbitRequestService service = new QbitRequestService.Builder().config("").build();
        HashMap<String, Object> map = new HashMap<>(2);
        map.put("clientId", clientId);
        map.put("refreshToken", refreshToken);
        String res = service.postRequest(uri, map);
        service.close();
        return JsonUtil.toBean(res, RefreshTokenRes.class);
    }
}