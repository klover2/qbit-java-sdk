package com.qbit.service;

import com.qbit.httpclient.constant.Constant;
import com.qbit.httpclient.util.JsonUtil;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class QbitRequestServiceTest extends TestCase {

    @Test
    public void testPostRequest() {
//        QbitRequestService service = new QbitRequestService.Builder().config("").build();
//        String url = "http://127.0.0.1:3000/open-api/oauth/authorize?clientId=qbit1f6efee44ceb8ca2";
//        String request = service.getRequest(url);
//        Map<String, Object> map1 = JsonUtil.parse(request);
//        System.out.println(map1);
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("clientId", "qbit1f6efee44ceb8ca2");
//        map.put("clientSecret", "8f70d42a1393802aebf567be27a47879");
//        assert map1 != null;
//        map.put("code", map1.get("code"));
//        String request1 = service.postRequest("http://127.0.0.1:3000/open-api/oauth/access-token", map);
//        System.out.println(request1);
//        service.close();
        QbitRequestService service = new QbitRequestService.Builder().config("497e1cc59d9f70cdcfb3deb394ecdca890f3178e").build();
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", "6e3b3de9-4ffd-4e25-9477-bd1c9d965554");
        String res = service.getRequest("http://127.0.0.1:3000/open-api/v1/budget", map);
        service.close(); // 如果想同时请求多个接口 这个请放在最后关闭
        Map<String, Object> parse = JsonUtil.parse(res);
        System.out.println(parse);
    }

    @Test
    public void testGetRequest() {
    }
}