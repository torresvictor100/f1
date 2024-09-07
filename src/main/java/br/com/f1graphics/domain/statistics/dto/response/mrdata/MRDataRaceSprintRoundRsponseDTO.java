package br.com.f1graphics.domain.statistics.dto.response.mrdata;

import br.com.f1graphics.domain.statistics.dto.DTO;
import br.com.f1graphics.domain.statistics.dto.response.racetable.RaceSprintTableRoundResponseDTO;
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
public class MRDataRaceSprintRoundRsponseDTO extends MRDataResponseDTO implements Serializable, DTO {

    @JsonProperty("RaceTable")
    private RaceSprintTableRoundResponseDTO raceTable;


}
