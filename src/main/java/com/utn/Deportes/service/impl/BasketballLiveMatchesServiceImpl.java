package com.utn.Deportes.service.impl;

import com.utn.Deportes.model.BasketballLiveMatchesDTO;
import com.utn.Deportes.model.BasketballLiveMatchesListDTO;
import com.utn.Deportes.service.BasketballLiveMatchesService;
import com.utn.Deportes.util.JsonBodyHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Service
public class BasketballLiveMatchesServiceImpl implements BasketballLiveMatchesService {

    @Override
    public HttpResponse getBasketballLiveMatches() throws IOException, InterruptedException  {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://sports-live-scores.p.rapidapi.com/basketball/live"))
                .header("X-RapidAPI-Key", "ccd680da65msh65bdc5b63d14f67p1f3ec9jsndc559442c399")
                .header("X-RapidAPI-Host", "sports-live-scores.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<BasketballLiveMatchesListDTO> response = HttpClient.newHttpClient().send(request, new JsonBodyHandler<>(BasketballLiveMatchesListDTO.class));
        System.out.println(response.body());

        return response;
    }
}
