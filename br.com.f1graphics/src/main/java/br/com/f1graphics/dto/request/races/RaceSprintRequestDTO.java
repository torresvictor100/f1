package br.com.f1graphics.dto.request.races;

import br.com.f1graphics.dto.DTO;
import br.com.f1graphics.dto.request.CircuitRequestDTO;
import br.com.f1graphics.dto.request.ResultRequestDTO;
import br.com.f1graphics.dto.response.CircuitResponseDTO;
import br.com.f1graphics.dto.response.ResultResponseDTO;
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
public class RaceSprintRequestDTO implements Serializable, DTO {

    private String season;
    private String round;
    private String url;
    private String raceName;

    @JsonProperty("Circuit")
    private CircuitResponseDTO circuit;
    private String date;
    private String time;

    @JsonProperty("SprintResults")
    private List<ResultResponseDTO> sprintResults;

}
