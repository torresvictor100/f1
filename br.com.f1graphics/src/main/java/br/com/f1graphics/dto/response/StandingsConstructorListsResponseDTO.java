package br.com.f1graphics.dto.response;

import br.com.f1graphics.dto.DTO;
import br.com.f1graphics.dto.response.constructions.ConstructorStandingsResponseDTO;
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
public class StandingsConstructorListsResponseDTO implements Serializable, DTO {

    private String season;
    private String round;
    @JsonProperty("ConstructorStandings")
    private List<ConstructorStandingsResponseDTO> constructorStandings;
}
