package com.qbit.service;

import com.qbit.service.dto.Output;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class QbitRequestServiceTest extends TestCase {

    @Test
    public void testPostRequest() {
        QbitRequestService service = new QbitRequestService.Builder().config("497e1cc59d9f70cdcfb3deb394ecdca890f3178e").build();
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", "6e3b3de9-4ffd-4e25-9477-bd1c9d965554");
        Output res = service.getRequest("http://127.0.0.1:3000/open-api/v1/budget", map);
        service.close(); // 如果想同时请求多个接口 这个请放在最后关闭
        System.out.println(res);
    }

    @Test
    public void testGetRequest() {
    }
}