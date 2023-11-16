package br.com.f1graphics.service.impl;

import br.com.f1graphics.dto.factory.F1GraphicsFactory;
import br.com.f1graphics.dto.request.*;
import br.com.f1graphics.dto.response.ChampionshipResponseDTO;
import br.com.f1graphics.dto.response.ListNamesRacesResponseDTO;
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

    private final RacesService racesService;

    private static F1GraphicsFactory factory;

    @Override
    public DriverTableRequestDTO getDriversForSeason(String season){
        return driversFacade.getF1DriversForSeason(season)
                .getMrData().getDriverTable();
    }

    @Override
    public DriverRequestDTO getDriverForDriverId(String driverId){
        return driversFacade.getDriverForDriverId(driverId)
                .getMrData().getDriverTable().getDrivers().get(0);
    }

    @Override
    public RaceTableDriverIdRequestDTO getDriverResultsForDriverId(String driverId, String driver){
        return driversFacade.getDriverResultsForDriverId(driverId, driver).getMrData().getRaceTable();
    }

    @Override
    public ChampionshipResponseDTO getDriversSeason(String driverIdMain, String driverIdComparation, String season){

        return getDriversSeason(getDriverForDriverId(driverIdMain),
                getDriverForDriverId(driverIdComparation),
                racesService.getListNamesRacesForSeason(season), season);
    }


    private ChampionshipResponseDTO getDriversSeason(DriverRequestDTO driverMain, DriverRequestDTO driverComparation
            , ListNamesRacesResponseDTO listNamesRacingDTO , String season){

        RaceTableRoundRequestDTO raceTable = racesService.getResultSpintRacesForDriverSeason(season,driverMain.getDriverId());

        return factory.createChampionshipResponseDTO(season);
    }


}
