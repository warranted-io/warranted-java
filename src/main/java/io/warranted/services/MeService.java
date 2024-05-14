package io.warranted.services;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

import com.google.gson.Gson;
import io.warranted.Me;
import io.warranted.RequestParams;

public class MeService {
    private RequestParams params;
    private static Gson gson = new Gson();

    public MeService(RequestParams params) {
      this.params = params;
    }

    /**
     * Get info about the active user
     * @return an object with info about the active user
     * @throws Exception
     */
    public Me get() throws Exception {
      String url = String.format("%s/api/v1/me", this.params.getHost());
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
        throw new IOException("Error fetching me: " + response.statusCode());
      }
  
      String responseBody = response.body();
      Me me = gson.fromJson(responseBody, Me.class);
  
      return me;
    }
}
