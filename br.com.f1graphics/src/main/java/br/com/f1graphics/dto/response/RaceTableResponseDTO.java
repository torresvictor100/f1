package br.com.f1graphics.dto.response;

import br.com.f1graphics.dto.response.races.RaceResponseDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public abstract class RaceTableResponseDTO {

    String season;

    @JsonProperty("Races")
    List<RaceResponseDTO> races;

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public List<RaceResponseDTO> getRaces() {
        return races;
    }

    public void setRaces(List<RaceResponseDTO> races) {
        this.races = races;
    }
}
