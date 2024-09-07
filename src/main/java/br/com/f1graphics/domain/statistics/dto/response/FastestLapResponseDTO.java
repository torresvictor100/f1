package br.com.f1graphics.domain.statistics.dto.response;

import br.com.f1graphics.domain.statistics.dto.DTO;
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
public class FastestLapResponseDTO implements Serializable, DTO {

    private String rank;
    private String lap;

    @JsonProperty("Time")
    private TimeResponseDTO time;

    @JsonProperty("AverageSpeed")
    private AverageSpeedResponseDTO averageSpeed;

}
