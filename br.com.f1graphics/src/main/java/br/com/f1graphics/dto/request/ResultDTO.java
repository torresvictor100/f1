package br.com.f1graphics.dto.request;

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
public class ResultDTO implements Serializable, DTO {

    private String number;
    private String position;
    private String positionText;
    private String points;

    @JsonProperty("Driver")
    private DriverDTO driver;

    @JsonProperty("Constructor")
    private ConstructorDTO constructor;
    private String grid;
    private String laps;
    private String status;

    @JsonProperty("Time")
    private TimeDTO time;

    @JsonProperty("FastestLap")
    private FastestLapDTO fastestLap;

}
