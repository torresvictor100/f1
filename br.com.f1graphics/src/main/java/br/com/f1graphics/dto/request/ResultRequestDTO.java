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
public class ResultRequestDTO implements Serializable, DTO {

    private String number;
    private String position;
    private String positionText;
    private String points;

    @JsonProperty("Driver")
    private DriverRequestDTO driver;

    @JsonProperty("Constructor")
    private ConstructorRequestDTO constructor;
    private String grid;
    private String laps;
    private String status;

    @JsonProperty("Time")
    private TimeRequestDTO time;

    @JsonProperty("FastestLap")
    private FastestLapRequestDTO fastestLap;

}
