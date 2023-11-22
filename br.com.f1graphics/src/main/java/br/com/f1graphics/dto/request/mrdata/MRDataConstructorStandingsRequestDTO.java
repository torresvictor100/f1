
package br.com.f1graphics.dto.request.mrdata;

import br.com.f1graphics.dto.DTO;
import br.com.f1graphics.dto.request.stadingstable.StandingsTableConstructorRequestDTO;
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
public class MRDataConstructorStandingsRequestDTO extends MRDataRequestRequestDTO implements Serializable, DTO {

    @JsonProperty("StandingsTable")
    private StandingsTableConstructorRequestDTO standingsTable;




}
