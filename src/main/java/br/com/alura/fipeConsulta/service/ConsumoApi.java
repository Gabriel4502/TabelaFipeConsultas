package br.com.alura.fipeConsulta.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi {

    public String consulta(String endereco){
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse <String> response = null;

        try{
            try {
                response =  client.send( request, HttpResponse.BodyHandlers.ofString());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }catch (IOException ex){
            throw new RuntimeException();
        }
        String json = response.body();
        return json;
    }

}
