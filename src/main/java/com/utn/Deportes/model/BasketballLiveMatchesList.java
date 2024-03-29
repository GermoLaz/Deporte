package com.utn.Deportes.model;

import com.utn.Deportes.model.BasketballLiveMatches;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BasketballLiveMatchesList {
    private List<BasketballLiveMatches> matches;
}
