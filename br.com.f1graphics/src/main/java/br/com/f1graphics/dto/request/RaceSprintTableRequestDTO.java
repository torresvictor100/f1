package br.com.f1graphics.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public abstract class RaceSprintTableRequestDTO {

    String season;

    @JsonProperty("Races")
    List<RaceSprintRequestDTO> races;

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public List<RaceSprintRequestDTO> getRaces() {
        return races;
    }

    public void setRaces(List<RaceSprintRequestDTO> races) {
        this.races = races;
    }
}
