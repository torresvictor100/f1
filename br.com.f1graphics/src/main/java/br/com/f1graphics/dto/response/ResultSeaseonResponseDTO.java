package br.com.f1graphics.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResultSeaseonResponseDTO implements Serializable {

    private String raceName;
    private Double pointsChampionship;
    private Double pointsChampionshipRaces;
    private Double pointsChampionshipSprintRaces;

}
