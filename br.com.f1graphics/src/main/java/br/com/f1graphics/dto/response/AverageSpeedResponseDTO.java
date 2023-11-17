package br.com.f1graphics.dto.response;

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
public class AverageSpeedResponseDTO implements Serializable, DTO {

    private String units;
    private String speed;
}
