package com.qbit.httpclient.util;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Map;

/**
 * @author klover
 * description HmacCryptoUtil
 * date 2022/10/13 16:44
 */
public class HmacCryptoUtil {
    private static final String ALGORITHM = "HmacSHA256";

    /**
     * hmac-sha256签名
     *
     * @param data   待签名数据
     * @param secret 密钥
     * @return
     */
    public static String encryptHmacSHA256(Map<String, Object> data, String secret) throws NoSuchAlgorithmException, InvalidKeyException {
        String str = jsonToString(data);

        Key sk = new SecretKeySpec(secret.getBytes(), ALGORITHM);
        Mac mac = Mac.getInstance(sk.getAlgorithm());
        mac.init(sk);

        byte[] bytes = mac.doFinal(str.getBytes());
        return bytesToHex(bytes);
    }

    /**
     * bytes To Hex
     *
     * @param bytes 字节
     * @return String
     */
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        Formatter formatter = new Formatter(sb);
        for (byte b : bytes) {
            formatter.format("%02x", b);
        }
        // 完成16进制编码
        return sb.toString();
    }

    /**
     * json to string 并且排序
     *
     * @param data 待处理数据
     * @return
     */
    private static String jsonToString(Map<String, Object> data) {
        String[] keys = data.keySet().toArray(new String[0]);
        Arrays.sort(keys);
        StringBuilder sb = new StringBuilder();
        for (String key : keys) {
            Object val = data.get(key);
            if (val == null) {
                val = "";
            }
            sb.append(key).append("=").append(val).append("&");
        }
        String str = sb.toString();
        return str.substring(0, str.length() - 1);
    }
}