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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
@Slf4j
public class DriversServiceImpl implements DriversService {

    private final DriversFacade driversFacade;

    private final RacesService racesService;


    private Double pointsChampionshipRaces = 0.0;
    private Double pointsChampionshipSprintRaces = 0.0;

    private static F1GraphicsFactory factory;

    @Override
    public DriverTableResponseDTO getDriversForSeason(String season) {

        return factory.createDriverTableResponseDTO(driversFacade.getF1DriversForSeason(season)
                .getMrData().getDriverTable());
    }

    @Override
    public DriverResponseDTO getDriverForDriverId(String driverId) {
        return factory.createDriverResponse(driversFacade.getDriverForDriverId(driverId)
                .getMrData().getDriverTable().getDrivers().get(0));
    }

    @Override
    public x getDriverResultsForDriverId(String season, String driver) {

        return factory.createRaceTableResponseDTO(driversFacade.getDriverResultsForDriverId(season, driver)
                .getMrData().getRaceTable());
    }

    public RaceResponseDTO getRaceResultsForRound(String season, int round) {

        return factory.createRaceResponseDTO(driversFacade.getRaceResultsForRound(season
                , String.valueOf(round)).getMrData().getRaceTable().getRaces().get(0));
    }


}
