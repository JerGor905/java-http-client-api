package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        // Get
        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(new URI("https://postman-echo.com/get"))
                .version(HttpClient.Version.HTTP_2)
                .GET()
                .build();
        HttpResponse<String> getResponse = HttpClient.newHttpClient()
                .send(getRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("Status code: " + getResponse.statusCode());
        System.out.println("body:\n" + getResponse.body() + "\n");

        // POST
        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(new URI("https://postman-echo.com/post"))
                .headers("Content-Type", "text/plain;charset=UTF-8")
                .POST(HttpRequest.BodyPublishers.ofString("Sample request body"))
                .build();
        HttpResponse<String> postResponse = HttpClient.newHttpClient()
                .send(postRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("Status code: " + postResponse.statusCode());
        System.out.println("body:\n" + postResponse.body());
    }
}