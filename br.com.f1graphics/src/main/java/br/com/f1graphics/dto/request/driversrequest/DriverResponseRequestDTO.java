package br.com.f1graphics.dto.request.driversrequest;

import br.com.f1graphics.dto.DTO;
import br.com.f1graphics.dto.response.MRDataDriverResponseDTO;
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
public class DriverResponseRequestDTO implements Serializable, DTO {

    @JsonProperty("MRData")
    private MRDataDriverResponseDTO mrData;

}
