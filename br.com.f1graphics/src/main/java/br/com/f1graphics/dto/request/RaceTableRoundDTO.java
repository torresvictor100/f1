package br.com.f1graphics.dto.request;

import br.com.f1graphics.DTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RaceTableRoundDTO implements Serializable, DTO {

    private String season;
    private String round;
    private List<RaceDTO> races;

}