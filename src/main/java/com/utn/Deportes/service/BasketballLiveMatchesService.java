package com.utn.Deportes.service;

import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface BasketballLiveMatchesService {
    /**
     * List of live basketball matches
     *
     * @return A list of live basketball matches
     */
    ResponseEntity getBasketballLiveMatches() throws IOException, InterruptedException;
}
