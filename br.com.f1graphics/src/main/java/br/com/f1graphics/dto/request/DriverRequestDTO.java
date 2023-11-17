package br.com.f1graphics.dto.request;

import br.com.f1graphics.DTO;
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
public class DriverRequestDTO implements Serializable, DTO {

    private String driverId;
    private String url;
    private String givenName;
    private String familyName;
    private String dateOfBirth;
    private String nationality;

}


