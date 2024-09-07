package br.com.f1graphics.domain.statistics.dto.response.mrdataitens;

import br.com.f1graphics.domain.statistics.dto.DTO;
import br.com.f1graphics.domain.statistics.dto.response.mrdata.MRDataRaceRoundResponseDTO;
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
public class MRDataRaceRoundItensDTO extends MRDataItensRequestDTO implements Serializable, DTO {

    @JsonProperty("MRData")
    private MRDataRaceRoundResponseDTO mrData;

}
