package br.com.f1graphics.service.objects;

import br.com.f1graphics.dto.response.StandingsConstructorListsResponseDTO;

import java.util.List;

public interface ConstructorStandingsService {
    List<StandingsConstructorListsResponseDTO> getConstructorStandings();
}
