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

import java.util.ArrayList;
import java.util.List;

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

        int round =0;
        List<RaceChampionsResponseDTO> racesDTOChampionsResponse = new ArrayList<>();

        for (String namesRacing:listNamesRacingDTO.getListNamesRacesDTO()){

            RaceChampionsResponseDTO raceChampionsResponse = getRaceChampionsResponseDTO(season ,listDriversId, namesRacing, round) ;
            racesDTOChampionsResponse.add(raceChampionsResponse);

            round =  1 + Integer.valueOf(round);

        }

        return factory.createChampionshipResponseDTO(season, String.valueOf(listNamesRacingDTO.getListNamesRacesDTO().size()),racesDTOChampionsResponse);
    }


        private RaceChampionsResponseDTO getRaceChampionsResponseDTO(String season, ListDriversIdRequestDTO listDriversId, String namesRace, int round){


        return  factory.createRaceChampionsResponseDTO(getRaceResultsForRound(season,round), null, null);

    }

        public RaceResponseDTO getRaceResultsForRound(String season , int round){

           RaceRequestDTO raceRequestDTO= driversFacade.getRaceResultsForRound(season, String.valueOf(round)).getMrData().getRaceTable().getRaces().get(0);

        return factory.createRaceResponseDTO(driversFacade.getRaceResultsForRound(season, String.valueOf(round)).getMrData().getRaceTable().getRaces().get(0));
    }


}
