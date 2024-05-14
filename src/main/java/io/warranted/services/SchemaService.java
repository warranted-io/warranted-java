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
import io.warranted.Error;
import io.warranted.RequestParams;
import io.warranted.Schema;
import io.warranted.SchemaResponse;

public class SchemaService {
    private RequestParams params;
    private static Gson gson = new Gson();

    public SchemaService(RequestParams params) {
      this.params = params;
    }

    /**
     * Get the schema
     * @return the schema
     * @throws Exception
     */
    public Schema get() throws Exception {
      String url = String.format("%s/api/v1/schema", this.params.getHost());
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
      SchemaResponse schemaResponse = gson.fromJson(responseBody, SchemaResponse.class);
  
      return schemaResponse.getSchema();
    }

    /**
     * Update the schema
     * @param schema the schema object to update
     * @return the updated Schema
     * @throws Exception
     */
    public Schema update(Schema schema) throws Exception {
      String url = String.format("%s/api/v1/schema", this.params.getHost());
      URI uriObject = URI.create(url);
      HttpClient client = HttpClient.newHttpClient();
      String jsonBody = gson.toJson(schema);
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
          throw new IOException("Error updating schema: " + response.statusCode() + " Error: " + error.toString());
        } catch (JsonSyntaxException e) {
          throw new IOException("Error updating schema: " + response.statusCode());
        }
      }
  
      String responseBody = response.body();
      SchemaResponse schemaResponse = gson.fromJson(responseBody, SchemaResponse.class);
  
      return schemaResponse.getSchema();
    }
}
