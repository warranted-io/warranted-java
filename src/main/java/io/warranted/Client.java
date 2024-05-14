package io.warranted;

import java.lang.IllegalArgumentException;
import java.util.HashMap;
import java.util.Map;

import io.warranted.services.DecisionService;
import io.warranted.services.LawEnforcementRequestService;
import io.warranted.services.MeService;
import io.warranted.services.SchemaService;

public class Client {
    private final RequestParams params;
    public final DecisionService decisions;
    public final LawEnforcementRequestService lawEnforcementRequest;
    public final MeService me;
    public final SchemaService schema;

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
        this.params = new RequestParams(accountId, authToken, "https://app.warranted.io", new HashMap<String, String>());
        this.decisions = new DecisionService(this.params);
        this.lawEnforcementRequest = new LawEnforcementRequestService(this.params);
        this.me = new MeService(this.params);
        this.schema = new SchemaService(this.params);
    }

    /**
     * Set host
     * @param host the host to send requests to
     */
    public void setHost(String host) {
        this.params.setHost(host);
    }

    /**
     * Set headers
     * @param headers headers to be sent with a request
     */
    public void setHeaders(Map<String, String> headers) {
        this.params.setHeaders(headers);
    }

    /**
     * Validate the signature of a request
     * @param signature the signature from the X-Warranted-Signature to compare against
     * @param url the url that received the request
     * @param jsonData JSON request data
     * @return whether or not the signature matches
     */
    public boolean validateRequest(String signature, String url, String body) {
        String hmac = CryptoHelper.createHMAC(url, body, this.params.getAuthToken());
        return CryptoHelper.timeSafeCompare(signature, hmac);
    }
}