package br.com.f1graphics.dto.response.stadingstable;

import br.com.f1graphics.dto.DTO;
import br.com.f1graphics.dto.response.StandingsListsResponseDTO;
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
public class StandingsTableResponseDTO implements Serializable, DTO {

    private String season;
    @JsonProperty("StandingsLists")
    private List<StandingsListsResponseDTO> StandingsListsRequest;
}
