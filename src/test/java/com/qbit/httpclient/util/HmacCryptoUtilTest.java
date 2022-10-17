package com.qbit.httpclient.util;

import org.junit.jupiter.api.Test;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import static com.qbit.httpclient.util.HmacCryptoUtil.encryptHmacSHA256;

/**
 * hmac-sha256签名
 */
public class HmacCryptoUtilTest {

    @Test
    public void testEncryptHmacSHA256() throws NoSuchAlgorithmException, InvalidKeyException {
        Map<String, Object> data = new HashMap<>();
        data.put("id", "ee74c872-8173-4b67-81b1-5746e7d5ab88");
        data.put("accountId", null);
        data.put("holderId", "d2bd6ab3-3c28-4ac7-a7c4-b7eed5eee367");
        data.put("currency", "USD");
        data.put("settlementCurrency", null);
        data.put("counterparty", "SAILINGWOOD;;US;1800948598;;091000019");
        data.put("transactionAmount", 11);
        data.put("fee", 0);
        data.put("businessType", "Inbound");
        data.put("status", "Closed");
        data.put("transactionTime", "2021-11-22T07:34:10.997Z");
        data.put("transactionId", "124d3804-defa-4033-9f30-1d8b0468e506");
        data.put("clientTransactionId", null);
        data.put("createTime", "2021-11-22T07:34:10.997Z");
        data.put("appendFee", 0);
        String sign = encryptHmacSHA256(data, "25d55ad283aa400af464c76d713c07ad");
        System.out.println(sign.equals("8287d5539c03918c9de51176162c2bf7065d5a8756b014e3293be1920c20d102"));
    }
}