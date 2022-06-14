package com.utn.Deportes.service.impl;

import com.utn.Deportes.exception.ErrorBody;
import com.utn.Deportes.model.BasketballLiveMatchesList;
import com.utn.Deportes.service.BasketballLiveMatchesService;
import com.utn.Deportes.util.JsonBodyHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class BasketballLiveMatchesServiceImpl implements BasketballLiveMatchesService {

    @Override
    public ResponseEntity getBasketballLiveMatches() throws IOException, InterruptedException  {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://sports-live-scores.p.rapidapi.com/basketball/live"))
                .header("X-RapidAPI-Key", "ccd680da65msh65bdc5b63d14f67p1f3ec9jsndc559442c399")
                .header("X-RapidAPI-Host", "sports-live-scores.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<BasketballLiveMatchesList> response = HttpClient.newHttpClient().send(request, new JsonBodyHandler<>(BasketballLiveMatchesList.class));

        return response.body().getMatches().isEmpty() ? ResponseEntity.status(HttpStatus.OK).body(new ErrorBody("No hay partidos en vivo", 200)) : ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
