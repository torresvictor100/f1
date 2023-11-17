package br.com.f1graphics.dto.request;

import br.com.f1graphics.dto.DTO;
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
public class MRDataRaceRoundRequestDTO extends MRDataRequestRequestDTO implements Serializable, DTO {

    @JsonProperty("RaceTable")
    private RaceTableRoundRequestDTO raceTable;


}
