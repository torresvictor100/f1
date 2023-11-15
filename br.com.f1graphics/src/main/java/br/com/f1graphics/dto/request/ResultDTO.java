package br.com.f1graphics.dto.request;

import br.com.f1graphics.DTO;
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
    private DriverDTO driver;
    private ConstructorDTO constructor;
    private String grid;
    private String laps;
    private String status;
    private TimeDTO time;
    private FastestLapDTO fastestLap;

}
