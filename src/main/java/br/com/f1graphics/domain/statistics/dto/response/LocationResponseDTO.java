package br.com.f1graphics.domain.statistics.dto.response;

import br.com.f1graphics.domain.statistics.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LocationResponseDTO implements Serializable, DTO {

    private String lat;
    private String lon;
    private String locality;
    private String country;
}
