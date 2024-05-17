package io.warranted.services;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import io.warranted.Decision;
import io.warranted.DecisionResponse;
import io.warranted.Error;
import io.warranted.RequestParams;

/**
 * <p>DecisionService class.</p>
 *
 * @author warranted.io
 * @version $Id: $Id
 */
public class DecisionService {
    private RequestParams params;
    private static Gson gson = new Gson();

    /**
     * <p>Constructor for DecisionService.</p>
     *
     * @param params a {@link io.warranted.RequestParams} object
     */
    public DecisionService(RequestParams params) {
      this.params = params;
    }

    /**
     * Get a decision
     *
     * @param decisionId the id of the decision
     * @return the corresponding decision object
     * @throws java.lang.Exception
     */
    public Decision get(String decisionId) throws Exception {
      if (decisionId == null || !decisionId.startsWith("decision-")) {
        throw new IllegalArgumentException("Invalid decisionId. Must start with 'decision-'");
      }
  
      String url = String.format("%s/api/v1/decisions/%s", this.params.getHost(), decisionId);
      URI uriObject = URI.create(url);
      HttpClient client = HttpClient.newHttpClient();
      HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                    .uri(uriObject)
                    .header("User-Agent", this.params.getUserAgentHeader())
                    .header("Authorization", "Basic " + this.params.getEncodedCredentials())
                    .GET();

      // Add additional headers if provided
      Map<String, String> headers = this.params.getHeaders();
      if (headers != null) {
        for (Map.Entry<String, String> entry : headers.entrySet()) {
          requestBuilder.header(entry.getKey(), entry.getValue());
        }
      }

      // Build the request
      HttpRequest request = requestBuilder.build();
      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

      if (response.statusCode() != HttpURLConnection.HTTP_OK) {
        try {
          Error error = gson.fromJson(response.body(), Error.class);
          throw new IOException("Error fetching decision: " + response.statusCode() + " Error: " + error.toString());
        } catch (JsonSyntaxException e) {
          throw new IOException("Error fetching decision: " + response.statusCode());
        }
      }
  
      String responseBody = response.body();
      DecisionResponse decisionResponse = gson.fromJson(responseBody, DecisionResponse.class);
  
      return decisionResponse.getDecision();
    }
}
