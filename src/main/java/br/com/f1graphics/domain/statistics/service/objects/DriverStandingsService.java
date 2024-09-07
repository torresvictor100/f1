package br.com.f1graphics.domain.statistics.service.objects;

import br.com.f1graphics.domain.statistics.dto.response.StandingsListsResponseDTO;

import java.util.List;

public interface DriverStandingsService {
    List<StandingsListsResponseDTO> getDriverStandings();
}
