package br.com.f1graphics.domain.statistics.dto.response;

import br.com.f1graphics.domain.statistics.dto.DTO;
import br.com.f1graphics.domain.statistics.dto.response.races.RaceSeasonResponseDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SeasonResponseDTO implements Serializable, DTO {

    private String season;

    private String totalGPs;

    @JsonProperty("raceSeason")
    private List<RaceSeasonResponseDTO> raceSeason;

    private List<DriverPointsResponseDTO> driverPoints;

    private  ListNamesRacesResponseDTO listNamesRacesResponseDTO;

}
