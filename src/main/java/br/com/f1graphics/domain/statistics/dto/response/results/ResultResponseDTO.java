package br.com.f1graphics.domain.statistics.dto.response.results;

import br.com.f1graphics.domain.statistics.dto.DTO;
import br.com.f1graphics.domain.statistics.dto.response.FastestLapResponseDTO;
import br.com.f1graphics.domain.statistics.dto.response.TimeResponseDTO;
import br.com.f1graphics.domain.statistics.dto.response.ConstructorResponseDTO;
import br.com.f1graphics.domain.statistics.dto.response.drive.DriverResponseDTO;
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
public class ResultResponseDTO implements Serializable, DTO {

    private String number;
    private String position;
    private String positionText;
    private String points;

    @JsonProperty("Driver")
    private DriverResponseDTO driver;

    @JsonProperty("Constructor")
    private ConstructorResponseDTO constructor;
    private String grid;
    private String laps;
    private String status;

    @JsonProperty("Time")
    private TimeResponseDTO time;

    @JsonProperty("FastestLap")
    private FastestLapResponseDTO fastestLap;

}
