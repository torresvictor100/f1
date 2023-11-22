package br.com.f1graphics.service.objects;

import br.com.f1graphics.dto.request.StandingsConstructorListsRequestDTO;
import br.com.f1graphics.dto.request.StandingsListsRequestDTO;

import java.util.List;

public interface ConstructorStandingsService {
    List<StandingsConstructorListsRequestDTO> getConstructorStandings();
}
