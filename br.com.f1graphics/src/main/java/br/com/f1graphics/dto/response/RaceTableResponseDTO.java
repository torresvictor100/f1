package br.com.f1graphics.dto.response;

import br.com.f1graphics.DTO;
import br.com.f1graphics.dto.request.RaceRequestDTO;
import br.com.f1graphics.dto.request.RaceTableRequestDTO;
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
public class RaceTableResponseDTO implements Serializable, DTO {

    String season;

    @JsonProperty("Races")
    List<RaceResponseDTO> races;

    private String round;

    private String position;

    private String driverId;

}
