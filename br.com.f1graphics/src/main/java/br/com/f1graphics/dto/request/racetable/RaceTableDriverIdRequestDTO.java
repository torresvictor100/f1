package br.com.f1graphics.dto.request.racetable;

import br.com.f1graphics.dto.DTO;
import br.com.f1graphics.dto.request.racetable.RaceTableRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RaceTableDriverIdRequestDTO extends RaceTableRequestDTO implements Serializable, DTO {

    private String driverId;

}
