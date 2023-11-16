package br.com.f1graphics.service.impl;

import br.com.f1graphics.dto.factory.F1GraphicsFactory;
import br.com.f1graphics.dto.request.*;
import br.com.f1graphics.dto.response.*;
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
    public DriverTableResponseDTO getDriversForSeason(String season){

        return factory.createDriverTableResponseDTO(driversFacade.getF1DriversForSeason(season)
                .getMrData().getDriverTable());
    }

    @Override
    public DriverResponseDTO getDriverForDriverId(String driverId){
        return factory.createDriverResponse(driversFacade.getDriverForDriverId(driverId)
                .getMrData().getDriverTable().getDrivers().get(0));
    }

    @Override
    public RaceTableResponseDTO getDriverResultsForDriverId(String season, String driver){

        return factory.createRaceTableResponseDTO(driversFacade.getDriverResultsForDriverId(season, driver)
                .getMrData().getRaceTable());
    }

    @Override
    public ChampionshipResponseDTO getChampionshipResponseDTO(String season, ListDriversIdRequestDTO listDriversId){

        return getChampionshipResponseDTO(season,listDriversId,racesService.getListNamesRacesForSeason(season));
    }


    private ChampionshipResponseDTO getChampionshipResponseDTO(String season, ListDriversIdRequestDTO listDriversId
            ,ListNamesRacesResponseDTO listNamesRacingDTO){
        for (String driverIds:listDriversId.getListDriversIdRequestDTO()){

            RaceTableResponseDTO raceTableResponseDTO = getDriverResultsForDriverId(driverIds, season);

            System.out.println(raceTableResponseDTO.getRound());
        }



        return factory.createChampionshipResponseDTO(season, String.valueOf(listNamesRacingDTO.getListNamesRacesDTO().size()), null);
    }


    private RaceChampionsResponseDTO getRaceChampionsResponseDTO(){



        return null;
    }


}
