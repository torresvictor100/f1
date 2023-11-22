package br.com.f1graphics.dto.request.racetable;

import br.com.f1graphics.dto.DTO;
import br.com.f1graphics.dto.request.races.RaceRequestDTO;
import br.com.f1graphics.dto.request.racetable.RaceTableRequestDTO;
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
public class RaceTableRoundRequestDTO extends RaceTableRequestDTO implements Serializable, DTO {

    private String round;

    @JsonProperty("Races")
    List<RaceRequestDTO> races;

}
