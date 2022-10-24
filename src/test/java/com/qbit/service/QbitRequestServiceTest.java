package com.qbit.service;

import com.qbit.service.dto.Output;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class QbitRequestServiceTest extends TestCase {

    @Test
    public void testPostRequest() {
        QbitRequestService service = new QbitRequestService.Builder().config("0df2034025a919958fcaa0cffc140bab469e4c59").build();
        HashMap<String, Object> map = new HashMap<>();
        map.put("cardId", "6e3b3de9-4ffd-4e25-9477-bd1c9d965554");
//        map.put("name", "预算名");
//        map.put("cost", 10);
        Output res = service.deleteRequest("http://127.0.0.1:3000/open-api/v1/cards", map);
        System.out.println(res);
    }

    @Test
    public void testGetRequest() {
    }
}