package io.warranted.services;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import io.warranted.Error;
import io.warranted.LawEnforcementRequest;
import io.warranted.LawEnforcementRequest.DeleteResponse;
import io.warranted.LawEnforcementRequestResponse;
import io.warranted.LawEnforcementRequestsResponse;
import io.warranted.RequestParams;

public class LawEnforcementRequestService {
    private RequestParams params;
    private static Gson gson = new Gson();

    public LawEnforcementRequestService(RequestParams params) {
      this.params = params;
    }

    /**
     * Get up to 500 law enforcement requests
     * @return a list of law enforcement requests
     * @throws Exception
     */
    public List<LawEnforcementRequest> get() throws Exception {
      return this.get(0, 500);
    }

    /**
     * Get up to 500 law enforcement requests
     * @param startAt a non negative integer
     * @return a list of law enforcement requests
     * @throws Exception
     */
    public List<LawEnforcementRequest> get(int startAt) throws Exception {
      return this.get(startAt, 500);
    }

    /**
     * Get up to 500 law enforcement requests
     * @param startAt a non negative integer
     * @param limit an integer between 1 and 500 inclusive
     * @return
     * @throws Exception
     */
    public List<LawEnforcementRequest> get(int startAt, int limit) throws Exception {
      if (startAt < 0 || limit < 1 || limit > 500) {
        throw new IllegalArgumentException("Invalid startAt or limit. startAt must be a non negative integer and limit must be an integer between 1 and 500 inclusive");
      }
      String url = String.format("%s/api/v1/lawEnforcementRequests?startAt=%d&limit=%d", this.params.getHost(), startAt, limit);
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
          throw new IOException("Error fetching lawEnforcementRequests: " + response.statusCode() + " Error: " + error.toString());
        } catch (JsonSyntaxException e) {
          throw new IOException("Error fetching lawEnforcementRequests: " + response.statusCode());
        }
      }
  
      String responseBody = response.body();
      LawEnforcementRequestsResponse lawEnforcementRequestsResponse = gson.fromJson(responseBody, LawEnforcementRequestsResponse.class);
  
      return lawEnforcementRequestsResponse.getLawEnforcementRequests();
    }

    /**
     * Get a law enforcement request
     * @param lawEnforcementRequestId the id of the law enforcement request
     * @return the corresponding lawEnforcementRequest object
     * @throws Exception
     */
    public LawEnforcementRequest get(String lawEnforcementRequestId) throws Exception {
      String url = String.format("%s/api/v1/lawEnforcementRequests/%s", this.params.getHost(), lawEnforcementRequestId);
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
          throw new IOException("Error fetching lawEnforcementRequest: " + response.statusCode() + " Error: " + error.toString());
        } catch (JsonSyntaxException e) {
          throw new IOException("Error fetching lawEnforcementRequest: " + response.statusCode());
        }
      }
  
      String responseBody = response.body();
      LawEnforcementRequestResponse lawEnforcementRequestResponse = gson.fromJson(responseBody, LawEnforcementRequestResponse.class);
  
      return lawEnforcementRequestResponse.getLawEnforcementRequest();
    }

    public LawEnforcementRequest add(File file) throws Exception {
      String url = String.format("%s/api/v1/lawEnforcementRequest/new", this.params.getHost());
      URI uriObject = URI.create(url);
      HttpClient client = HttpClient.newHttpClient();
      HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                    .uri(uriObject)
                    .header("User-Agent", this.params.getUserAgentHeader())
                    .header("Content-Type", "multipart/form-data")
                    .header("Authorization", "Basic " + this.params.getEncodedCredentials())
                    .POST(HttpRequest.BodyPublishers.ofFile(file.toPath()));

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
          throw new IOException("Error creating lawEnforcementRequest: " + response.statusCode() + " Error: " + error.toString());
        } catch (JsonSyntaxException e) {
          throw new IOException("Error creating lawEnforcementRequest: " + response.statusCode());
        }
      }
  
      String responseBody = response.body();
      LawEnforcementRequestResponse lawEnforcementRequestResponse = gson.fromJson(responseBody, LawEnforcementRequestResponse.class);
  
      return lawEnforcementRequestResponse.getLawEnforcementRequest();
    }

    /**
     * Update a law enforcement request
     * @param lawEnforcementRequest the law enforcement request to update
     * @return the updated lawEnforcementRequest object
     * @throws Exception
     */
    public LawEnforcementRequest update(LawEnforcementRequest lawEnforcementRequest) throws Exception {
      String encodedId = URLEncoder.encode(lawEnforcementRequest.getId(), StandardCharsets.UTF_8.toString());
      String url = String.format("%s/api/v1/lawEnforcementRequests/%s", this.params.getHost(), encodedId);
      URI uriObject = URI.create(url);
      HttpClient client = HttpClient.newHttpClient();
      String jsonBody = gson.toJson(lawEnforcementRequest);
      HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                    .uri(uriObject)
                    .header("User-Agent", this.params.getUserAgentHeader())
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Basic " + this.params.getEncodedCredentials())
                    .PUT(HttpRequest.BodyPublishers.ofString(jsonBody));

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
          throw new IOException("Error updating lawEnforcementRequest: " + response.statusCode() + " Error: " + error.toString());
        } catch (JsonSyntaxException e) {
          throw new IOException("Error updating lawEnforcementRequest: " + response.statusCode());
        }
      }
  
      String responseBody = response.body();
      LawEnforcementRequestResponse lawEnforcementRequestResponse = gson.fromJson(responseBody, LawEnforcementRequestResponse.class);
  
      return lawEnforcementRequestResponse.getLawEnforcementRequest();
    }

    /**
     * Delete a law enforcement request
     * @param lawEnforcementRequestId the id of the law enforcement request
     * @return a DeleteResponse object
     * @throws Exception
     */
    public DeleteResponse delete(String lawEnforcementRequestId) throws Exception {
      String url = String.format("%s/api/v1/lawEnforcementRequests/%s", this.params.getHost(), lawEnforcementRequestId);
      URI uriObject = URI.create(url);
      HttpClient client = HttpClient.newHttpClient();
      HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                    .uri(uriObject)
                    .header("User-Agent", this.params.getUserAgentHeader())
                    .header("Authorization", "Basic " + this.params.getEncodedCredentials())
                    .DELETE();

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
          throw new IOException("Error deleting lawEnforcementRequest: " + response.statusCode() + " Error: " + error.toString());
        } catch (JsonSyntaxException e) {
          throw new IOException("Error deleting lawEnforcementRequest: " + response.statusCode());
        }
      }
  
      String responseBody = response.body();
      DeleteResponse deleteResponse = gson.fromJson(responseBody, DeleteResponse.class);
  
      return deleteResponse;
    }
}
