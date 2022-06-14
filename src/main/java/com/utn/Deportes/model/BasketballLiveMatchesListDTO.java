package com.utn.Deportes.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BasketballLiveMatchesListDTO {
    private List<BasketballLiveMatchesDTO> basketballLiveMatchesDTOList;
}
