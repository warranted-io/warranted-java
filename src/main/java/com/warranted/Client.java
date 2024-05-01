package com.warranted;

import java.lang.IllegalArgumentException;

public class Client {
    private final String accountId;
    private final String authToken;

    /**
     * Warranted Client Constructor
     * @param accountId the account id
     * @param authToken the primary auth token
     */
    public Client(String accountId, String authToken) {
        if (accountId == null || accountId.isEmpty()) {
            throw new IllegalArgumentException("No accountId provided");
        }
        if (authToken == null || authToken.isEmpty()) {
            throw new IllegalArgumentException("No authToken provided");
        }
        this.accountId = accountId;
        this.authToken = authToken;
    }

    /**
     * Validate the signature of a request
     * @param signature the signature from the X-Warranted-Signature to compare against
     * @param url the url that received the request
     * @param jsonData JSON request data
     * @return whether or not the signature matches
     */
    public boolean validateRequest(String signature, String url, String body) {
        CryptoHelper cryptoHelper = new CryptoHelper();
        String hmac = cryptoHelper.createHMAC(url, body, this.authToken);
        return cryptoHelper.timeSafeCompare(signature, hmac);
    }
}