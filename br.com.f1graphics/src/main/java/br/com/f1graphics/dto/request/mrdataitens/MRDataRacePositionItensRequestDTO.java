package br.com.f1graphics.dto.request.mrdataitens;

import br.com.f1graphics.dto.DTO;
import br.com.f1graphics.dto.request.mrdata.MRDataRacePositionRequestDTO;
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
public class MRDataRacePositionItensRequestDTO extends MRDataItensRequestDTO implements Serializable, DTO {

    @JsonProperty("MRData")
    private MRDataRacePositionRequestDTO mrData;

}
