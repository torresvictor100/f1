package br.com.f1graphics.dto.response;

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
public class ResultChampionshipTableResponseDTO implements Serializable {

    @JsonProperty("ResultChampionshipResponseDTO")
    private ResultChampionshipResponseDTO resultChampionshipResponseDTO;

    @JsonProperty("ResultRaceResponseDTO")
    private ResultRaceResponseDTO resultRaceResponseDTO;

}
