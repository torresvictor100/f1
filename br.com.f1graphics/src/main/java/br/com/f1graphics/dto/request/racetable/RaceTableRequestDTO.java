package br.com.f1graphics.dto.request.racetable;

import br.com.f1graphics.dto.request.races.RaceRequestDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public abstract class RaceTableRequestDTO {

    String season;

    @JsonProperty("Races")
    List<RaceRequestDTO> races;

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public List<RaceRequestDTO> getRaces() {
        return races;
    }

    public void setRaces(List<RaceRequestDTO> races) {
        this.races = races;
    }
}
