package br.com.f1graphics.dto.response;

import br.com.f1graphics.DTO;
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
public class RaceChampionsResponseDTO implements Serializable, DTO {


    private String round;
    private String url;
    private String raceName;
    private String laps;

    @JsonProperty("Circuit")
    private CircuitResponseDTO circuit;
    private String date;
    private String time;

    @JsonProperty("DriversResults")
    private List<DriverChampionsResponseDTO> driversResults;

}
