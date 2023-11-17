package br.com.f1graphics.service.impl;

import br.com.f1graphics.dto.factory.F1GraphicsFactory;
import br.com.f1graphics.dto.request.ListDriversIdRequestDTO;
import br.com.f1graphics.dto.request.MRDataRaceRoundItensDTO;
import br.com.f1graphics.dto.request.RaceRequestDTO;
import br.com.f1graphics.dto.request.RaceTableRoundRequestDTO;
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
    public RaceTableResponseDTO getDriverResultsForDriverId(String season, String driver) {

        return factory.createRaceTableResponseDTO(driversFacade.getDriverResultsForDriverId(season, driver)
                .getMrData().getRaceTable());
    }

    @Override
    public ChampionshipResponseDTO getChampionshipResponseDTO(String season, ListDriversIdRequestDTO listDriversId) {



        return getChampionshipResponseDTO(season, listDriversId, racesService.getListNamesRacesForSeason(season)
                , criarMapPoints(listDriversId), criarMapPoints(listDriversId), criarMapPoints(listDriversId));
    }

    private Map<String, Double> criarMapPoints(ListDriversIdRequestDTO listDriversId){

        Map<String, Double> pointsChampionship = new HashMap<>();
        for(String driver : listDriversId.getListDriversIdRequestDTO()){
            pointsChampionship.put(driver, 0.0);
        }

        return pointsChampionship;
    }


    private ChampionshipResponseDTO getChampionshipResponseDTO(String season, ListDriversIdRequestDTO listDriversId
            , ListNamesRacesResponseDTO listNamesRacingDTO, Map<String, Double> MapPointsChampionship
            , Map<String, Double> MapPointsChampionshipRaces , Map<String, Double> MapPointsChampionshipSprintRaces) {

        int round = 0;
        List<RaceChampionsResponseDTO> racesDTOChampionsResponse = new ArrayList<>();

        for (String namesRacing : listNamesRacingDTO.getListNamesRacesDTO()) {

            RaceChampionsResponseDTO raceChampionsResponse = getRaceChampionsResponseDTO(season
                    , listDriversId, namesRacing, round, MapPointsChampionship,
                    MapPointsChampionshipRaces,MapPointsChampionshipSprintRaces );
            racesDTOChampionsResponse.add(raceChampionsResponse);

            round = 1 + Integer.valueOf(round);

        }

        return factory.createChampionshipResponseDTO(season
                , String.valueOf(listNamesRacingDTO.getListNamesRacesDTO().size()), racesDTOChampionsResponse);
    }


    private RaceChampionsResponseDTO getRaceChampionsResponseDTO(String season
            , ListDriversIdRequestDTO listDriversId, String namesRace, int round , Map<String, Double> MapPointsChampionship
            , Map<String, Double> MapPointsChampionshipRaces , Map<String, Double> MapPointsChampionshipSprintRaces) {


        RaceResponseDTO race = getRaceResultsForRound(season, round);

        List<DriverChampionsResponseDTO> driverListChampionsResponse = new ArrayList<>();

        RaceTableResponseDTO mrDataRaceRoundItensDTO = racesService.getResultSpintRaces(season,String.valueOf(race.getRound()));
        RaceResponseDTO raceSprint = new RaceResponseDTO();

        if(mrDataRaceRoundItensDTO.getRaces().size() != 0){
            raceSprint = racesService.getResultSpintRaces(season,String.valueOf(round)).getRaces().get(0);
        }




        for (String driversId : listDriversId.getListDriversIdRequestDTO()) {
            driverListChampionsResponse.add(getDriverChampionsResponseDTO(driversId, race, MapPointsChampionship
                        , MapPointsChampionshipRaces , MapPointsChampionshipSprintRaces, raceSprint));
        }

        return factory.createRaceChampionsResponseDTO(race, race.getCircuit(), driverListChampionsResponse);

    }

    private DriverChampionsResponseDTO getDriverChampionsResponseDTO(String driversId, RaceResponseDTO race
            , Map<String, Double> MapPointsChampionship, Map<String, Double> MapPointsChampionshipRaces
            , Map<String, Double> mapPointsChampionshipSprintRaces,RaceResponseDTO raceSprint) {

        int resultInt = 0;

        for (ResultResponseDTO result : race.getResults()) {

            if (race.getResults().get(resultInt).getDriver().getDriverId().equals(driversId)) {


                MapPointsChampionshipRaces = setNewPointForRace(driversId,Double.valueOf(race.getResults().get(resultInt).getPoints())
                        , MapPointsChampionshipRaces);

                if (raceSprint.getResults() != null && raceSprint.getResults().get(resultInt).getDriver().getDriverId().equals(driversId)) {
                    mapPointsChampionshipSprintRaces = setNewPointForRace(driversId,Double.valueOf(race.getResults().get(resultInt).getPoints())
                            , mapPointsChampionshipSprintRaces);

                    MapPointsChampionship = getPointsChampionship(driversId,Double.valueOf(race.getResults().get(resultInt).getPoints())
                            ,Double.valueOf(raceSprint.getResults().get(resultInt).getPoints()), MapPointsChampionship);

                }else {

                    MapPointsChampionship = getPointsChampionship(driversId,Double.valueOf(race.getResults().get(resultInt).getPoints())
                            ,0.0, MapPointsChampionship);

                }
                return factory.createDriverChampionsResponseDTO(race.getResults().get(resultInt)
                        , getResultRaceResponseDTO(race.getResults().get(resultInt))
                        , getResultChampionshipResponseDTO(race.getRaceName(), MapPointsChampionship.get(driversId)
                                , MapPointsChampionshipRaces.get(driversId), mapPointsChampionshipSprintRaces.get(driversId)));
            }
            resultInt++;
        }

        return null;
    }

    private ResultRaceResponseDTO getResultRaceResponseDTO(ResultResponseDTO resultRaceResponseDTO) {

        return factory.createResultRaceResponseDTO(resultRaceResponseDTO);
    }

    private ResultChampionshipResponseDTO getResultChampionshipResponseDTO(String raceName, Double pointsChampionship
            , Double pointsChampionshipRaces, Double pointsChampionshipSprintRaces) {


        return factory.createResultChampionshipResponse(raceName, pointsChampionship
                , pointsChampionshipRaces, pointsChampionshipSprintRaces);
    }

    public RaceResponseDTO getRaceResultsForRound(String season, int round) {


        return factory.createRaceResponseDTO(driversFacade.getRaceResultsForRound(season
                , String.valueOf(round)).getMrData().getRaceTable().getRaces().get(0));
    }

    private Map<String, Double> setNewPointForRace(String driverId, Double points, Map<String, Double> MapPointsChampionship){

        Double pointsNow = MapPointsChampionship.get(driverId);

        if (MapPointsChampionship.containsKey(driverId)) {

            pointsNow = pointsNow + points;

            MapPointsChampionship.put(driverId, pointsNow);

        }
        MapPointsChampionship.put(driverId,pointsNow);

        return MapPointsChampionship;
    }

    private Map<String, Double> getPointsChampionship(String driverId, Double pointsRace, Double pointsSpint
            ,Map<String, Double> MapPointsChampionship){

        Double pointsChampionNow = MapPointsChampionship.get(driverId);

        if (MapPointsChampionship.containsKey(driverId)) {

            pointsChampionNow = pointsChampionNow + pointsRace + pointsSpint;

            MapPointsChampionship.put(driverId, pointsChampionNow);

        }

        MapPointsChampionship.put(driverId,pointsChampionNow);

        return MapPointsChampionship;
    }


}
