package br.com.f1graphics.domain.statistics.dto.response.racetable;

import br.com.f1graphics.domain.statistics.dto.DTO;
import br.com.f1graphics.domain.statistics.dto.response.races.RaceResponseDTO;
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
public class RaceTableDriverIdResponseDTO implements Serializable, DTO {

    String season;

    @JsonProperty("Races")
    List<RaceResponseDTO> races;

    private String driverId;

}