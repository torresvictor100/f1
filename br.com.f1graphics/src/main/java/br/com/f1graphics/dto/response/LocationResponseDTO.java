package br.com.f1graphics.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LocationResponseDTO {

    private String lat;
    private String lon;
    private String locality;
    private String country;
}
