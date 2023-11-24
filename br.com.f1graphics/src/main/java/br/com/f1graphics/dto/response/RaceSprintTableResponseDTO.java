package br.com.f1graphics.dto.response;

import br.com.f1graphics.dto.response.races.RaceSprintResponseDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public abstract class RaceSprintTableResponseDTO {

    String season;

    @JsonProperty("Races")
    List<RaceSprintResponseDTO> races;

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public List<RaceSprintResponseDTO> getRaces() {
        return races;
    }

    public void setRaces(List<RaceSprintResponseDTO> races) {
        this.races = races;
    }
}
