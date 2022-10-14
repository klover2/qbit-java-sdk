package com.qbit.service;

import com.qbit.httpclient.util.JsonUtil;
import com.qbit.service.dto.AccessTokenRes;
import com.qbit.service.dto.CodeRes;
import com.qbit.service.dto.RefreshTokenRes;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class AuthServiceTest extends TestCase {

    @Test
    public void testGetCode() {
        AuthService service = new AuthService.Builder()
                .config("qbit1f6efee44ceb8ca2", "8f70d42a1393802aebf567be27a47879", "http://127.0.0.1:3000")
                .build();

        CodeRes code = service.getCode("123", "http://127.0.0.1:3000");
        System.out.println(code);
    }

    @Test
    public void testGetAccessToken() {
        AuthService service = new AuthService.Builder().config("qbit1f6efee44ceb8ca2", "8f70d42a1393802aebf567be27a47879", "http://127.0.0.1:3000").build();
        AccessTokenRes accessToken = service.getAccessToken("983146b6575420ff87dc63a10ddd6175");
        System.out.println(accessToken);
        // AccessTokenRes(accessToken=6f24940c7aa34fcd2d10da6a52f0714b007ab419, refreshToken=c7968e9bb72234ca6475b12da4db8c7a2b8108b2240413c24e0f35f00d32c560, expiresIn=86400, timestamp=1665755612, message=null)
    }

    @Test
    void refreshToken() {
        AuthService service = new AuthService.Builder().config("qbit1f6efee44ceb8ca2", "8f70d42a1393802aebf567be27a47879", "http://127.0.0.1:3000").build();
        RefreshTokenRes res = service.refreshToken("c7968e9bb72234ca6475b12da4db8c7a2b8108b2240413c24e0f35f00d32c560");
        System.out.println(res);
        // RefreshTokenRes(accessToken=9ce5744a00af89bf0d25f170ebd2a02ce1e88aec, expiresIn=86400, timestamp=1665755613, code=null, message=null)
    }
}