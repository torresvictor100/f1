package br.com.f1graphics.dto.request;

import br.com.f1graphics.dto.DTO;
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
public class RaceSprintTableRoundRequestDTO extends RaceSprintTableRequestDTO implements Serializable, DTO {

    private String round;

    @JsonProperty("Races")
    List<RaceSprintRequestDTO> races;

}
