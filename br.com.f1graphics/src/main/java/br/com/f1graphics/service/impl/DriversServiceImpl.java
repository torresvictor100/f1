package br.com.f1graphics.service.impl;

import br.com.f1graphics.dto.request.*;
import br.com.f1graphics.facade.DriversFacade;
import br.com.f1graphics.service.objects.DriversService;
import br.com.f1graphics.service.objects.RacesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class DriversServiceImpl implements DriversService {

    private final DriversFacade driversFacade;

    private final RacesService raceService;

    public DriverTableDTO getDriversForSeason(String season){
        return driversFacade.getF1DriversForSeason(season)
                .getMrData().getDriverTable();
    }

    public DriverDTO getDriverForDriverId(String driverId){
        return driversFacade.getDriverForDriverId(driverId)
                .getMrData().getDriverTable().getDrivers().get(0);
    }

    public RaceTableDriverIdDTO getDriverResultsForDriverId(String driverId, String driver){
        return driversFacade.getDriverResultsForDriverId(driverId, driver).getMrData().getRaceTable();
    }

    public DriverDTO getDriversSeason(String driverIdMain,String driverIdComparation, String season){

        return getDriversSeason(getDriverForDriverId(driverIdMain),
                getDriverForDriverId(driverIdComparation),
                raceService.getListNamesRaceForSeason(season), season);
    }


    private DriverDTO getDriversSeason(DriverDTO driverMain, DriverDTO driverComparation
            , ListNamesRacingDTO listNamesRacingDTO , String season){

        RaceTableDriverIdDTO driveMainResults = getDriverResultsForDriverId(driverMain.getDriverId(), season);

        RaceTableDriverIdDTO driverComparationResults = getDriverResultsForDriverId(driverComparation.getDriverId(), season);

        return null;
    }


}
