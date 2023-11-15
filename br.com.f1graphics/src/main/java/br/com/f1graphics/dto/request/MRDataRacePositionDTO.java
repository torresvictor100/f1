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
public class MRDataRacePositionDTO implements Serializable, DTO {

    private String xmlns;
    private String series;
    private String url;
    private String limit;
    private String offset;
    private String total;

    @JsonProperty("DriverTable")
    private RaceTablePositionDTO driverTable;


}
