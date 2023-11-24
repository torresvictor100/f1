package br.com.f1graphics.service.objects;

import br.com.f1graphics.dto.response.StandingsListsResponseDTO;

import java.util.List;

public interface DriverStandingsService {
    List<StandingsListsResponseDTO> getDriverStandings();
}
