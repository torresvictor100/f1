package br.com.f1graphics.dto.response;

import br.com.f1graphics.dto.DTO;
import br.com.f1graphics.dto.request.driversrequest.DriverRequestDTO;
import br.com.f1graphics.dto.response.StandingsConstructorsResponseDTO;
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
public class DriverStandingsRequestDTO implements Serializable, DTO {

    private String position;
    private String positionText;
    private String points;
    private String wins;
    @JsonProperty("Driver")
    private DriverRequestDTO driver;
    @JsonProperty("Constructors")
    private List<StandingsConstructorsResponseDTO> constructors;

}
