package com.qbit.service;

import com.qbit.service.dto.AccessTokenOutput;
import com.qbit.service.dto.CodeOutput;
import com.qbit.service.dto.RefreshTokenOutput;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

public class AuthServiceTest extends TestCase {

    @Test
    public void testGetCode() throws Exception {
        AuthService service = new AuthService.Builder()
                .config("qbit1f6efee44ceb8ca2", "8f70d42a1393802aebf567be27a47879", "http://127.0.0.1:3000")
                .build();

        CodeOutput codeRes = service.getCode("123", "http://127.0.0.1:3000");
        AccessTokenOutput res = service.getAccessToken(codeRes.getCode());
        System.out.println(res);
    }

    @Test
    public void testGetAccessToken() {
        AuthService service = new AuthService.Builder().config("qbit1f6efee44ceb8ca2", "8f70d42a1393802aebf567be27a47879", "http://127.0.0.1:3000").build();
        AccessTokenOutput res = service.getAccessToken("62e6320e98035f16f91a4c397bb58e20");
        System.out.println(res);
    }

    @Test
    void refreshToken() {
        // 17fe0e1872722ea356746836c889d22c40893650
        AuthService service = new AuthService.Builder().config("qbit1f6efee44ceb8ca2", "8f70d42a1393802aebf567be27a47879", "http://127.0.0.1:3000").build();
        RefreshTokenOutput res = service.refreshToken("42c1092c4d6abac451cf31fffc1200abf4205141f6a2073e52022c978635490c1");
        System.out.println(res);
    }
}