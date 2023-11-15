package br.com.f1graphics.service.objects;

import br.com.f1graphics.dto.request.DriverDTO;
import br.com.f1graphics.dto.request.DriverTableDTO;
import br.com.f1graphics.dto.request.RaceTableDriverIdDTO;

public interface DriversService {

    DriverTableDTO getDriversForSeason(String season);

    DriverDTO getDriverForDriverId(String driverId);

    RaceTableDriverIdDTO getDriverResultsForDriverId(String driverId, String driver);

    DriverDTO getDriversSeason(String driverIdMain,String driverIdComparation, String season);
}
