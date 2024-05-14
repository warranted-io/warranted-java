# Warranted Java
A helper library for using the Warranted.io API.

## Installation
`warranted-java` uses Maven. At present the jars are available from a public maven repository.

Use the following dependency in your project to grab via Maven:

```xml
<dependency>
  <groupId>io.warranted.sdk</groupId>
  <artifactId>warranted</artifactId>
  <version>1.X.X</version>
  <scope>compile</scope>
</dependency>
```

or Gradle:

```
implementation "io.warranted.sdk:warranted:1.X.X"
```

### Test your installation
To make sure the installation was successful, try hitting the `/api/v1/me` API, like this:
```java
import io.warranted.Client;
import io.warranted.Me;

public class Example {
  public static void main(String[] args) {
    // Get your Account Id and Auth Token from https://app.warranted.io/settings/webhook
    public static final String ACCOUNT_ID = System.getenv("WARRANTED_ACCOUNT_ID");
    public static final String AUTH_TOKEN = System.getenv("WARRANTED_AUTH_TOKEN");
    Client client = new Client(ACCOUNT_ID, AUTH_TOKEN);

    // Fetch and print the response object
    Me me = client.me.get();
    System.out.println(me.toString());
  }
}
```

## Usage
Check out [our docs](https://app.warranted.io/docs) for more details.