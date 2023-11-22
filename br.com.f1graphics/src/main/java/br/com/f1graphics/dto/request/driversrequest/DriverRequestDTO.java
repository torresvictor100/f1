package br.com.f1graphics.dto.request.driversrequest;

import br.com.f1graphics.dto.DTO;
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
    private String code;
    private String permanentNumber;
    private String givenName;
    private String familyName;
    private String dateOfBirth;
    private String nationality;

}

