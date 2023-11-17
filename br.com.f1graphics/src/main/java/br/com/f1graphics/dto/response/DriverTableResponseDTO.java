package br.com.f1graphics.dto.response;

import br.com.f1graphics.dto.DTO;
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
public class DriverTableResponseDTO implements Serializable, DTO {

    private String season;

    @JsonProperty("Drivers")
    private List<DriverResponseDTO> drivers;


}
