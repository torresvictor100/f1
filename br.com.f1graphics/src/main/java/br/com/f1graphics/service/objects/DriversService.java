package br.com.f1graphics.service.objects;

import br.com.f1graphics.dto.request.DriverRequestDTO;
import br.com.f1graphics.dto.request.DriverTableRequestDTO;
import br.com.f1graphics.dto.request.ListDriversIdRequestDTO;
import br.com.f1graphics.dto.response.*;

public interface DriversService {

    DriverTableResponseDTO getDriversForSeason(String season);

    DriverResponseDTO getDriverForDriverId(String driverId);

    RaceTableResponseDTO getDriverResultsForDriverId(String driverId, String driver);

    ChampionshipResponseDTO getChampionshipResponseDTO(String season, ListDriversIdRequestDTO listDriversId);

    public RaceResponseDTO getRaceResultsForRound(String season, int round);
}
