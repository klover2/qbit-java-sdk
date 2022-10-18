package com.qbit.service.impl;

import com.qbit.httpclient.constant.Constant;
import com.qbit.httpclient.http.HttpDeleteWithBody;
import com.qbit.httpclient.util.JsonUtil;
import com.qbit.service.QbitRequestService;
import com.qbit.service.dto.ErrOutput;
import com.qbit.service.dto.Output;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.requireNonNull;

/**
 * @author klover
 * description QbitRequestServiceImpl
 * date 2022/10/14 12:16
 */
public class QbitRequestServiceImpl implements QbitRequestService {
    private final CloseableHttpClient httpClient;
    private final String accessToken;

    public QbitRequestServiceImpl(CloseableHttpClient httpClient, String accessToken) {
        this.httpClient = requireNonNull(httpClient);
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
        CloseableHttpResponse response = null;
        try {
            // 构建Post请求对象
            HttpPost req = new HttpPost(url);

            // 设置传送的内容类型是json格式
            req.setHeader(Constant.CONTENT_TYPE, "application/json;charset=utf-8");
            // 接收的内容类型也是json格式
            req.setHeader(Constant.X_QBIT_ACCESS_TOKEN, this.accessToken);
            // 设置超时时间，其中connectionRequestTimout（从连接池获取连接的超时时间）、connetionTimeout（客户端和服务器建立连接的超时时间）、socketTimeout（客户端从服务器读取数据的超时时间），单位都是毫秒
            RequestConfig config = RequestConfig.custom().setConnectTimeout(10000).setConnectionRequestTimeout(3000).
                    setSocketTimeout(20000).build();
            req.setConfig(config);

            String jsonString = JsonUtil.toJSONString(params);

            // 设置请求体
            req.setEntity(new StringEntity(jsonString, "UTF-8"));
            // 获取返回对象
            response = this.httpClient.execute(req);
            return this.delResponse(response);
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
            throw new RuntimeException("出现连接/超时异常");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("执行内部代码时出现异常");
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
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
        CloseableHttpResponse response = null;
        try {
            // 构建Put请求对象
            HttpPut req = new HttpPut(url);

            // 设置传送的内容类型是json格式
            req.setHeader(Constant.CONTENT_TYPE, "application/json;charset=utf-8");
            // 接收的内容类型也是json格式
            req.setHeader(Constant.X_QBIT_ACCESS_TOKEN, this.accessToken);
            // 设置超时时间，其中connectionRequestTimout（从连接池获取连接的超时时间）、connetionTimeout（客户端和服务器建立连接的超时时间）、socketTimeout（客户端从服务器读取数据的超时时间），单位都是毫秒
            RequestConfig config = RequestConfig.custom().setConnectTimeout(10000).setConnectionRequestTimeout(3000).
                    setSocketTimeout(20000).build();
            req.setConfig(config);

            String jsonString = JsonUtil.toJSONString(params);

            // 设置请求体
            req.setEntity(new StringEntity(jsonString, "UTF-8"));
            // 获取返回对象
            response = this.httpClient.execute(req);
            return this.delResponse(response);
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
            throw new RuntimeException("出现连接/超时异常");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("执行内部代码时出现异常");
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
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
        CloseableHttpResponse response = null;
        try {
            // 构建Delete请求对象
            HttpDeleteWithBody req = new HttpDeleteWithBody(url);

            // 设置传送的内容类型是json格式
            req.setHeader(Constant.CONTENT_TYPE, "application/json;charset=utf-8");
            // 接收的内容类型也是json格式
            req.setHeader(Constant.X_QBIT_ACCESS_TOKEN, this.accessToken);
            // 设置超时时间，其中connectionRequestTimout（从连接池获取连接的超时时间）、connetionTimeout（客户端和服务器建立连接的超时时间）、socketTimeout（客户端从服务器读取数据的超时时间），单位都是毫秒
            RequestConfig config = RequestConfig.custom().setConnectTimeout(10000).setConnectionRequestTimeout(3000).
                    setSocketTimeout(20000).build();
            req.setConfig(config);

            String jsonString = JsonUtil.toJSONString(params);

            // 设置请求体
            req.setEntity(new StringEntity(jsonString, "UTF-8"));
            // 获取返回对象
            response = this.httpClient.execute(req);
            return this.delResponse(response);
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
            throw new RuntimeException("出现连接/超时异常");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("执行内部代码时出现异常");
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
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
        CloseableHttpResponse response = null;
        try {
            StringBuilder uri = new StringBuilder(url);
            int i = 0;
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                if (i == 0) {
                    uri.append("?");
                } else {
                    uri.append("&");
                }
                uri.append(entry.getKey()).append("=").append(entry.getValue());
                ++i;
            }

            // 构建Get请求对象
            HttpGet req = new HttpGet(uri.toString());
            // 设置传送的内容类型是json格式
            req.setHeader(Constant.CONTENT_TYPE, "application/json;charset=utf-8");
            // 接收的内容类型也是json格式
            req.setHeader(Constant.X_QBIT_ACCESS_TOKEN, this.accessToken);

            // 设置超时时间，其中connectionRequestTimout（从连接池获取连接的超时时间）、connetionTimeout（客户端和服务器建立连接的超时时间）、socketTimeout（客户端从服务器读取数据的超时时间），单位都是毫秒
            RequestConfig config = RequestConfig.custom().setConnectTimeout(10000).setConnectionRequestTimeout(3000)
                    .setSocketTimeout(20000).build();
            req.setConfig(config);
            // 获取返回对象
            response = this.httpClient.execute(req);
            return this.delResponse(response);
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
            throw new RuntimeException("出现连接/超时异常");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("执行内部代码时出现异常");
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭流请求
     */
    @Override
    public void close() {
        try {
            this.httpClient.close();
        } catch (IOException ignored) {
        }
    }

    /**
     * 处理返回
     */
    private Output delResponse(CloseableHttpResponse response) throws IOException {
        StatusLine statusLine = response.getStatusLine();
        int statusCode = statusLine.getStatusCode();

        // 整理返回值
        HttpEntity entity = response.getEntity();
        String res = EntityUtils.toString(entity, "UTF-8");

        Object resObj = JsonUtil.parse(res);
        if (resObj == null) {
            resObj = res;
        }

        Output output = new Output();
        output.setStatus(statusCode);
        // 成功返回
        if (statusCode >= 200 && statusCode < 300) {
            output.setData(resObj);
        } else {
            output.setErr(JsonUtil.toBean(resObj, ErrOutput.class));
        }
        return output;
    }
}