package br.com.f1graphics.dto.response;

import br.com.f1graphics.dto.DTO;
import br.com.f1graphics.dto.response.RaceTableResponseDTO;
import br.com.f1graphics.dto.response.races.RaceResponseDTO;
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
public class RaceTableRoundResponseDTO extends RaceTableResponseDTO implements Serializable, DTO {

    private String round;

    @JsonProperty("Races")
    List<RaceResponseDTO> races;

}
