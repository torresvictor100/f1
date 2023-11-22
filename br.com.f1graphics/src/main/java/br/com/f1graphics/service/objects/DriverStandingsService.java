package br.com.f1graphics.service.objects;

import br.com.f1graphics.dto.request.*;
import br.com.f1graphics.dto.response.SeaseonResponseDTO;

import java.util.List;

public interface DriverStandingsService {
    List<StandingsListsRequestDTO> getDriverStandings();
}
