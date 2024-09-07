package br.com.f1graphics.domain.statistics.service.objects;

import br.com.f1graphics.domain.statistics.dto.response.StandingsConstructorListsResponseDTO;

import java.util.List;

public interface ConstructorStandingsService {
    List<StandingsConstructorListsResponseDTO> getConstructorStandings();
}
