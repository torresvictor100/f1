package br.com.f1graphics.service.objects;

import br.com.f1graphics.dto.request.DriverRequestDTO;
import br.com.f1graphics.dto.request.DriverTableRequestDTO;
import br.com.f1graphics.dto.response.ChampionshipResponseDTO;
import br.com.f1graphics.dto.response.DriverResponseDTO;
import br.com.f1graphics.dto.response.DriverTableResponseDTO;
import br.com.f1graphics.dto.response.RaceTableResponseDTO;

public interface DriversService {

    DriverTableResponseDTO getDriversForSeason(String season);

    DriverResponseDTO getDriverForDriverId(String driverId);

    RaceTableResponseDTO getDriverResultsForDriverId(String driverId, String driver);

    ChampionshipResponseDTO getDriversSeason(String driverIdMain, String driverIdComparation, String season);
}
