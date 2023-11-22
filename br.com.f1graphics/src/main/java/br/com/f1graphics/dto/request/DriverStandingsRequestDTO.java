package br.com.f1graphics.dto.request;

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
public class DriverStandingsRequestDTO implements Serializable, DTO {

    private String position;
    private String positionText;
    private String points;
    private String wins;
    @JsonProperty("Driver")
    private DriverRequestDTO driver;
    @JsonProperty("Constructors")
    private ConstructorRequestDTO constructors;

}
