package com.qbit.httpclient.http;

import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

import javax.annotation.concurrent.NotThreadSafe;
import java.net.URI;

/**
 * @author klover
 * description HttpDeleteWithBody
 * date 2022/10/14 12:08
 */
@NotThreadSafe
public class HttpDeleteWithBody extends HttpEntityEnclosingRequestBase {
    public static final String METHOD_NAME = "DELETE";

    public String getMethod() {
        return METHOD_NAME;
    }

    public HttpDeleteWithBody(final String uri) {
        super();
        setURI(URI.create(uri));
    }

    public HttpDeleteWithBody(final URI uri) {
        super();
        setURI(uri);
    }

    public HttpDeleteWithBody() {
        super();
    }
}