package net.openwebinars.java11.http;

import java.io.IOException;
import java.net.Authenticator;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class EjemploHttp {

    public static void main(String[] args) throws IOException, InterruptedException, TimeoutException, ExecutionException {

        // Construcción del cliente HTTP
        // Una vez construido, es inmutable
        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(30))
                .version(HttpClient.Version.HTTP_2)
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build();

        /*
            PETICIÓN SÍNCRONA SOBRE UNA WEB
         */
        HttpRequest request = HttpRequest.newBuilder()
                                .GET()
                                .uri(URI.create("https://www.google.com/search?q=openwebinars"))
                                .setHeader("User-Agent", "Cliente Java 11")
                                .build();
        // Obtenemos la respuesta como un String
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Mostramos los encabezados
        System.out.println(response.version().toString());
        response.headers().map().forEach((x,y) -> System.out.printf("%s: %s\n", x,y));
        System.out.println();
        System.out.println(response.body().substring(0, 1000));
        System.out.println("\n\n\n");

        /*
            PETICIÓN ASÍNCRONA SOBRE UNA API REST
         */
        HttpRequest asyncRequest = HttpRequest.newBuilder()
                                    .GET()
                                    .uri(URI.create("http://api.openweathermap.org/data/2.5/weather?q=Seville,Spain&units=metric&lang=es&appid=ccb3263e748c51a3ab262c4f76d00c3d"))
                                    .setHeader("User-Agent", "Cliente Java 11")
                                    .build();


        // La respuesta devuelve un CompletableFuture<HttpResponse<String>>

        CompletableFuture<HttpResponse<String>> completableFuture =
                client.sendAsync(asyncRequest, HttpResponse.BodyHandlers.ofString());

        HttpResponse<String> asyncResponse =
                completableFuture.get(5, TimeUnit.SECONDS);

        System.out.println(asyncResponse.version().toString());
        asyncResponse.headers().map().forEach((x,y) -> System.out.printf("%s: %s\n", x,y));
        System.out.println();
        System.out.println(asyncResponse.body());
        System.out.println("\n\n\n");


    }

}
