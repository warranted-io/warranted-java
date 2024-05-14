package io.warranted;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Map;

public class RequestParams {
    private String accountId;
    private String authToken;
    private String host;
    private Map<String, String> headers;
    private static String version = "1.0.0";

    public RequestParams(String accountId, String authToken, String host, Map<String, String> headers) {
        this.accountId = accountId;
        this.authToken = authToken;
        this.host = host;
        this.headers = headers;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getAuthToken() {
        return authToken;
    }

    public String getHost() {
        return host;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public String getEncodedCredentials() throws UnsupportedEncodingException {
        String credentials = accountId + ":" + authToken;
        final byte[] bytes = credentials.getBytes("UTF-8");
        return new String(Base64.getEncoder().encode(bytes));
    }

    public String getUserAgentHeader() {
        String os = System.getProperty("os.name");
        String architecture = System.getProperty("os.arch");
        String javaVersion = System.getProperty("java.version");

        return String.format("warranted-java/%s (%s %s) java/%s", version, os, architecture, javaVersion);
    }
}
