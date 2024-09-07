package br.com.f1graphics.domain.statistics.dto.response.drive;

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
public class DriverResponseDTO implements Serializable, DTO {

    @JsonProperty("driverId")
    private String driverId;
    private String url;
    private String code;
    private String permanentNumber;
    private String givenName;
    private String familyName;
    private String dateOfBirth;
    private String nationality;

}


