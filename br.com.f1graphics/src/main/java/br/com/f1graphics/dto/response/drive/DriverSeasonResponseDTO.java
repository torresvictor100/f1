
package br.com.f1graphics.dto.response.drive;

import br.com.f1graphics.dto.DTO;
import br.com.f1graphics.dto.response.ConstructorResponseDTO;
import br.com.f1graphics.dto.response.ResultRaceResponseDTO;
import br.com.f1graphics.dto.response.ResultSeaseonResponseDTO;
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
public class DriverSeasonResponseDTO implements Serializable, DTO {

    private String driverId;
    @JsonProperty("Constructor")
    private ConstructorResponseDTO constructor;

    private String permanentNumber;
    private String code;
    private String url;
    private String givenName;
    private String familyName;
    private String dateOfBirth;
    private String nationality;

    @JsonProperty("ResultChampionshipResponseDTO")
    private ResultSeaseonResponseDTO resultChampionshipResponseDTO;

    @JsonProperty("ResultRace")
    private ResultRaceResponseDTO resultRaceResponse;

}


