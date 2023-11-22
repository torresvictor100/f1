package br.com.f1graphics.dto.request.stadingstable;

import br.com.f1graphics.dto.DTO;
import br.com.f1graphics.dto.request.StandingsConstructorListsRequestDTO;
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
public class StandingsTableConstructorRequestDTO implements Serializable, DTO {

    private String season;
    @JsonProperty("StandingsLists")
    private List<StandingsConstructorListsRequestDTO> StandingsListsRequest;
}
