package br.com.f1graphics.domain.statistics.dto.response.mrdata;

import br.com.f1graphics.domain.statistics.dto.DTO;
import br.com.f1graphics.domain.statistics.dto.response.drive.RaceTablePositionResponseDTO;
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
public class MRDataRacePositionResponseDTO extends MRDataResponseDTO implements Serializable, DTO {

    @JsonProperty("RaceTable")
    private RaceTablePositionResponseDTO raceTable;


}
