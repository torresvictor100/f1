package br.com.f1graphics.dto.response.results;

import br.com.f1graphics.dto.DTO;
import br.com.f1graphics.dto.response.FastestLapResponseDTO;
import br.com.f1graphics.dto.response.TimeResponseDTO;
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
public class ResultRaceResponseDTO implements Serializable, DTO {

    private String position;
    private String points;
    private String grid;
    @JsonProperty("Time")
    private TimeResponseDTO time;
    @JsonProperty("FastestLap")
    private FastestLapResponseDTO fastestLap;
}
