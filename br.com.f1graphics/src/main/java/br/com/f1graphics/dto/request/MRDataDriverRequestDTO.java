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
public class MRDataDriverRequestDTO extends MRDataRequestRequestDTO implements Serializable, DTO {

    @JsonProperty("DriverTable")
    private DriverTableRequestDTO driverTable;


}
