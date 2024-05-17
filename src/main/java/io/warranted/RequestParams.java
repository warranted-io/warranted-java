package io.warranted;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Map;

/**
 * <p>RequestParams class.</p>
 *
 * @author warranted.io
 * @version $Id: $Id
 */
public class RequestParams {
    private String accountId;
    private String authToken;
    private String host;
    private Map<String, String> headers;
    private static String version = "1.0.0";

    /**
     * <p>Constructor for RequestParams.</p>
     *
     * @param accountId a {@link java.lang.String} object
     * @param authToken a {@link java.lang.String} object
     * @param host a {@link java.lang.String} object
     * @param headers a {@link java.util.Map} object
     */
    public RequestParams(String accountId, String authToken, String host, Map<String, String> headers) {
        this.accountId = accountId;
        this.authToken = authToken;
        this.host = host;
        this.headers = headers;
    }

    /**
     * <p>Getter for the field <code>accountId</code>.</p>
     *
     * @return a {@link java.lang.String} object
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * <p>Getter for the field <code>authToken</code>.</p>
     *
     * @return a {@link java.lang.String} object
     */
    public String getAuthToken() {
        return authToken;
    }

    /**
     * <p>Getter for the field <code>host</code>.</p>
     *
     * @return a {@link java.lang.String} object
     */
    public String getHost() {
        return host;
    }

    /**
     * <p>Getter for the field <code>headers</code>.</p>
     *
     * @return a {@link java.util.Map} object
     */
    public Map<String, String> getHeaders() {
        return headers;
    }

    /**
     * <p>Setter for the field <code>accountId</code>.</p>
     *
     * @param accountId a {@link java.lang.String} object
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    /**
     * <p>Setter for the field <code>authToken</code>.</p>
     *
     * @param authToken a {@link java.lang.String} object
     */
    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    /**
     * <p>Setter for the field <code>host</code>.</p>
     *
     * @param host a {@link java.lang.String} object
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * <p>Setter for the field <code>headers</code>.</p>
     *
     * @param headers a {@link java.util.Map} object
     */
    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    /**
     * <p>getEncodedCredentials.</p>
     *
     * @return a {@link java.lang.String} object
     * @throws java.io.UnsupportedEncodingException if any.
     */
    public String getEncodedCredentials() throws UnsupportedEncodingException {
        String credentials = accountId + ":" + authToken;
        final byte[] bytes = credentials.getBytes("UTF-8");
        return new String(Base64.getEncoder().encode(bytes));
    }

    /**
     * <p>getUserAgentHeader.</p>
     *
     * @return a {@link java.lang.String} object
     */
    public String getUserAgentHeader() {
        String os = System.getProperty("os.name");
        String architecture = System.getProperty("os.arch");
        String javaVersion = System.getProperty("java.version");

        return String.format("warranted-java/%s (%s %s) java/%s", version, os, architecture, javaVersion);
    }
}
