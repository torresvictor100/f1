package br.com.f1graphics.dto.response;

import br.com.f1graphics.DTO;
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
public class CircuitResponseDTO implements Serializable, DTO {

    private String circuitId;
    private String url;
    private String circuitName;
    @JsonProperty("Location")
    private LocationResponseDTO location;
}
