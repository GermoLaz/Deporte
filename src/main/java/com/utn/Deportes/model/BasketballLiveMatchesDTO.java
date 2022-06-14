package com.utn.Deportes.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BasketballLiveMatchesDTO {
    @JsonAlias("Away Score")
    private Integer awayScore;
    @JsonAlias("Away Team")
    private String awayTeam;
    @JsonAlias("Home Score")
    private Integer homeScore;
    @JsonAlias("Home Team")
    private String homeTeam;
    @JsonAlias("Initial Away Odd")
    private Double initialAwayOdd;
    @JsonAlias("Initial Home Odd")
    private Double initialHomeOdd;
    @JsonAlias("League")
    private String league;
    @JsonAlias("League ID")
    private Integer leagueID;
    @JsonAlias("Odd")
    private Double odd;
    @JsonAlias("Live Home Odd")
    private Double liveHomeOdd;
    @JsonAlias("Match ID")
    private Integer matchID;
    @JsonAlias("Period 1 Away")
    private Integer period1Away;
    @JsonAlias("Period 1 Home")
    private Integer period1Home;
    @JsonAlias("Period 2 Away")
    private Integer period2Away;
    @JsonAlias("Period 2 Home")
    private Integer  period2Home;
    @JsonAlias("Period 3 Away")
    private Integer  period3Away;
    @JsonAlias("Period 3 Home")
    private Integer  period3Home;
    @JsonAlias("Status")
    private String Status;
}
