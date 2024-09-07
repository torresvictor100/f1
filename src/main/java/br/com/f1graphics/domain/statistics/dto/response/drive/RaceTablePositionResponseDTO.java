package br.com.f1graphics.domain.statistics.dto.response.drive;

import br.com.f1graphics.domain.statistics.dto.DTO;
import br.com.f1graphics.domain.statistics.dto.response.racetable.RaceTableResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RaceTablePositionResponseDTO extends RaceTableResponseDTO implements Serializable, DTO {

    private String position;

}
