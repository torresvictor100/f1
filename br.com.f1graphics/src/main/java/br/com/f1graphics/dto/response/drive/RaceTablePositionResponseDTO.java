package br.com.f1graphics.dto.response.drive;

import br.com.f1graphics.dto.DTO;
import br.com.f1graphics.dto.response.racetable.RaceTableResponseDTO;
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
