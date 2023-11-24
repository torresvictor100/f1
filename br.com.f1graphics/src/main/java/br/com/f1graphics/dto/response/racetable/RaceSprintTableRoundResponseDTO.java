package br.com.f1graphics.dto.response.racetable;

import br.com.f1graphics.dto.DTO;
import br.com.f1graphics.dto.response.races.RaceSprintResponseDTO;
import br.com.f1graphics.dto.response.racetable.RaceSprintTableResponseDTO;
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
public class RaceSprintTableRoundResponseDTO extends RaceSprintTableResponseDTO implements Serializable, DTO {

    private String round;

    @JsonProperty("Races")
    List<RaceSprintResponseDTO> races;

}
