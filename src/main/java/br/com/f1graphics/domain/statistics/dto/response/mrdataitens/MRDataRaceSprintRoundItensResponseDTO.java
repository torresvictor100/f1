package br.com.f1graphics.domain.statistics.dto.response.mrdataitens;

import br.com.f1graphics.domain.statistics.dto.DTO;
import br.com.f1graphics.domain.statistics.dto.response.mrdata.MRDataRaceSprintRoundRsponseDTO;
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
public class MRDataRaceSprintRoundItensResponseDTO extends MRDataItensRequestDTO implements Serializable, DTO {

    @JsonProperty("MRData")
    private MRDataRaceSprintRoundRsponseDTO mrData;

}
