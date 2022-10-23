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
                .config("qbit1f6efee44ceb8ca2", "8f70d42a1393802aebf567be27a47879", "http:///127.0.0.1:3000")
                .build();

        CodeOutput res = service.getCode("123", "http://127.0.0.1:3000");
        System.out.println(res);
    }

    @Test
    public void testGetAccessToken() {
        AuthService service = new AuthService.Builder().config("qbit1f6efee44ceb8ca2", "8f70d42a1393802aebf567be27a47879", "http://127.0.0.1:3000").build();
        AccessTokenOutput res = service.getAccessToken("62e6320e98035f16f91a4c397bb58e20");
//        System.out.println(res.getData().getAccessToken());
    }

    @Test
    void refreshToken() {
        AuthService service = new AuthService.Builder().config("qbit1f6efee44ceb8ca2", "8f70d42a1393802aebf567be27a47879", "http://127.0.0.1:3000").build();
        RefreshTokenOutput res = service.refreshToken("75b13bb8b002c9dbfa047f9f04a3412b2d7f20fa848fc1d07c97f8aef19ba0ac");
        System.out.println(res);
    }
}