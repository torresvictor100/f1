
package br.com.f1graphics.dto.response;

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
public class MRDataRaceDriverIdResponseDTO extends MRDataRequestResponseDTO implements Serializable, DTO {

    @JsonProperty("RaceTable")
    private RaceTableDriverIdResponseDTO raceTable;


}
