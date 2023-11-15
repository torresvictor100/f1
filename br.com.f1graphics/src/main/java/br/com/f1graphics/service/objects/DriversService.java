package br.com.f1graphics.service.objects;

import br.com.f1graphics.dto.request.DriverRequestDTO;
import br.com.f1graphics.dto.request.DriverTableRequestDTO;
import br.com.f1graphics.dto.request.RaceTableDriverIdRequestDTO;

public interface DriversService {

    DriverTableRequestDTO getDriversForSeason(String season);

    DriverRequestDTO getDriverForDriverId(String driverId);

    RaceTableDriverIdRequestDTO getDriverResultsForDriverId(String driverId, String driver);

    DriverRequestDTO getDriversSeason(String driverIdMain, String driverIdComparation, String season);
}
