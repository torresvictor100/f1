package br.com.f1graphics.dto.response;

import br.com.f1graphics.dto.DTO;
import br.com.f1graphics.dto.response.drive.DriverResponseDTO;
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
public class DriverStandingsResponseDTO implements Serializable, DTO {

    private String position;
    private String positionText;
    private String points;
    private String wins;
    @JsonProperty("Driver")
    private DriverResponseDTO driver;
    @JsonProperty("Constructors")
    private List<StandingsConstructorsResponseDTO> constructors;

}
