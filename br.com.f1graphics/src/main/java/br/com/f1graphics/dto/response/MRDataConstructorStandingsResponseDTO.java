
package br.com.f1graphics.dto.response;

import br.com.f1graphics.dto.DTO;
import br.com.f1graphics.dto.response.stadingstable.StandingsTableConstructorResponseDTO;
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
public class MRDataConstructorStandingsResponseDTO extends MRDataRequestResponseDTO implements Serializable, DTO {

    @JsonProperty("StandingsTable")
    private StandingsTableConstructorResponseDTO standingsTable;




}
