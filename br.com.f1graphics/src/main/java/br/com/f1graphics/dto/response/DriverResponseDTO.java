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
public class DriverResponseDTO implements Serializable, DTO {

    @JsonProperty("Constructor")
    private ConstructorResponseDTO constructor;
    private String url;
    private String givenName;
    private String familyName;
    private String dateOfBirth;
    private String nationality;
    private String driverId;
    @JsonProperty("Results")
    private List<ResultResponseDTO> results;
}
