package br.com.f1graphics.domain.statistics.dto.response.constructions;

import br.com.f1graphics.domain.statistics.dto.DTO;
import br.com.f1graphics.domain.statistics.dto.response.StandingsConstructorsResponseDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConstructorStandingsResponseDTO implements Serializable, DTO {

    private String position;
    private String positionText;
    private String points;
    private String wins;

    @JsonProperty("Constructor")
    private StandingsConstructorsResponseDTO constructor;

}
