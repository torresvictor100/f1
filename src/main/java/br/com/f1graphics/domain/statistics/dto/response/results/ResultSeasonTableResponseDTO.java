package br.com.f1graphics.domain.statistics.dto.response.results;

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
public class ResultSeasonTableResponseDTO implements Serializable {



    @JsonProperty("ResultRaceResponseDTO")
    private ResultRaceResponseDTO resultRaceResponseDTO;

}
