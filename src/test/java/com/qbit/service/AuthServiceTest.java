package com.qbit.service;

import com.qbit.service.dto.CodeRes;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

public class AuthServiceTest extends TestCase {

    @Test
    public void testGetCode() {
        AuthService service = new AuthService.Builder()
                .config("qbit1f6efee44ceb8ca2", "8f70d42a1393802aebf567be27a47879", "http://127.0.0.1:3000/")
                .build();

        CodeRes code = service.getCode("123", "http://127.0.0.1:3000");
        System.out.println(code);
    }

    @Test
    public void testGetAccessToken() {
        AuthService service = new AuthService.Builder().config("qbit1f6efee44ceb8ca2", "8f70d42a1393802aebf567be27a47879", "http://127.0.0.1:3000/").build();
        Object accessToken = service.getAccessToken("983146b6575420ff87dc63a10ddd6175");
        System.out.println(accessToken);
    }
}