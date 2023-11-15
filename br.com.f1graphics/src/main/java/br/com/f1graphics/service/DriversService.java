package br.com.f1graphics.service;

import br.com.f1graphics.dto.request.*;
import br.com.f1graphics.facade.DriversFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Driver;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class DriversService {

    private final DriversFacade driversFacade;

    private final RaceService raceService;

    public DriverTableDTO getDriversForSeason(String season){
        return driversFacade.getF1DriversForSeason(season)
                .getMrData().getDriverTable();
    }

    public DriverDTO getDriverForDriverId(String driverId){
        return driversFacade.getDriverForDriverId(driverId)
                .getMrData().getDriverTable().getDrivers().get(0);
    }

    public DriverDTO getDriversSeason(String driverIdMain,String driverIdComparation, String season){

        return getDriversSeason(getDriverForDriverId(driverIdMain),
                getDriverForDriverId(driverIdComparation),
                raceService.getListNamesRaceForSeason(season));
    }



    private DriverDTO getDriversSeason(DriverDTO driverMain, DriverDTO driverComparation, ListNamesRacingDTO listNamesRacingDTO){
        return null;
    }


}
