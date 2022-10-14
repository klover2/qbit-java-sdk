package com.qbit.httpclient.constant;

/**
 * @author klover
 * description HTTP常量
 * date 2022/10/14 10:40
 */
public final class Constant {
    public static final String X_QBIT_ACCESS_TOKEN = "x-qbit-access-token";
    public static final String CONTENT_TYPE = "Content-Type";

    private static final String OS = System.getProperty("os.name") + "/" + System.getProperty("os.version");

    private static final String VERSION = System.getProperty("java.version");
}