package br.com.f1graphics.dto.request;

import br.com.f1graphics.dto.DTO;
import br.com.f1graphics.dto.request.constructions.ConstructorStandingsRequestDTO;
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
public class StandingsConstructorListsRequestDTO implements Serializable, DTO {

    private String season;
    private String round;
    @JsonProperty("ConstructorStandings")
    private List<ConstructorStandingsRequestDTO> constructorStandings;
}
