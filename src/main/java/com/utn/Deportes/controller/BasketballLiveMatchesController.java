package com.utn.Deportes.controller;

import com.utn.Deportes.service.BasketballLiveMatchesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/basketballLiveMatches")
public class BasketballLiveMatchesController {
    private BasketballLiveMatchesService basketballLiveMatchesService;

    @Autowired
    public BasketballLiveMatchesController(BasketballLiveMatchesService basketballLiveMatchesService){
        this.basketballLiveMatchesService = basketballLiveMatchesService;
    }

    @GetMapping("/")
    public ResponseEntity getBasketballLiveMatches() throws IOException, InterruptedException{
        return basketballLiveMatchesService.getBasketballLiveMatches();
    }
}
