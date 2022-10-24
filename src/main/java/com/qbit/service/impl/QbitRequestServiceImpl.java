package com.qbit.service.impl;

import com.qbit.httpclient.http.HttpRequestsBase;
import com.qbit.httpclient.util.JsonUtil;
import com.qbit.service.QbitRequestService;
import com.qbit.service.dto.Output;
import com.qbit.service.dto.ResponseOutput;
import com.qbit.service.dto.data.ContentOutput;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author klover
 * description QbitRequestServiceImpl
 * date 2022/10/14 12:16
 */
public class QbitRequestServiceImpl implements QbitRequestService {
    private final String accessToken;

    public QbitRequestServiceImpl(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * post 请求
     *
     * @param url    url
     * @param params 参数
     * @return String
     */
    @Override
    public Output postRequest(String url, Map<String, Object> params) {
        HttpRequestsBase service = new HttpRequestsBase.Builder().config(this.accessToken).build();
        ResponseOutput response = service.postRequest(url, params);
        try {
            return this.delResponse(response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            service.close();
        }
    }

    /**
     * put 请求
     *
     * @param url    url
     * @param params 参数
     * @return String
     */
    @Override
    public Output putRequest(String url, Map<String, Object> params) {
        HttpRequestsBase service = new HttpRequestsBase.Builder().config(this.accessToken).build();
        ResponseOutput response = service.putRequest(url, params);
        try {
            return this.delResponse(response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            service.close();
        }
    }

    /**
     * delete 请求
     *
     * @param url    url
     * @param params 参数
     * @return String
     */
    @Override
    public Output deleteRequest(String url, Map<String, Object> params) {
        HttpRequestsBase service = new HttpRequestsBase.Builder().config(this.accessToken).build();
        ResponseOutput response = service.deleteRequest(url, params);
        try {
            return this.delResponse(response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            service.close();
        }
    }

    /**
     * get 请求
     *
     * @param url url
     * @return String
     */
    @Override
    public Output getRequest(String url) {
        HashMap<String, Object> map = new HashMap<>(0);
        return this.getRequest(url, map);
    }

    /**
     * get 请求
     *
     * @param url   url
     * @param query 参数
     * @return String
     */
    @Override
    public Output getRequest(String url, Map<String, Object> query) {
        HttpRequestsBase service = new HttpRequestsBase.Builder().config(this.accessToken).build();
        ResponseOutput response = service.getRequest(url, query);
        try {
            return this.delResponse(response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            service.close();
        }
    }

    /**
     * 处理返回
     */
    private Output delResponse(ResponseOutput response) throws IOException {
        int statusCode = response.getStatus();
        String reason = response.getReason();
        // 整理返回值
        String res = response.getContent();

        Output output = new Output();
        output.setStatus(statusCode);
        output.setReason(reason);
        ContentOutput content = JsonUtil.toBean(res, ContentOutput.class);
        output.setContent(content);
        return output;
    }
}