package br.com.f1graphics.service.impl;

import br.com.f1graphics.dto.factory.F1GraphicsFactory;
import br.com.f1graphics.dto.request.ListDriversIdRequestDTO;
import br.com.f1graphics.dto.response.ResultRaceResponseDTO;
import br.com.f1graphics.dto.response.ResultResponseDTO;
import br.com.f1graphics.dto.response.ResultSeaseonResponseDTO;
import br.com.f1graphics.dto.response.SeaseonResponseDTO;
import br.com.f1graphics.dto.response.drive.DriverSeasonResponseDTO;
import br.com.f1graphics.dto.response.races.RaceResponseDTO;
import br.com.f1graphics.dto.response.races.RaceSeaseonResponseDTO;
import br.com.f1graphics.dto.response.races.RaceSprintResponseDTO;
import br.com.f1graphics.facade.DriversFacade;
import br.com.f1graphics.service.objects.RacesService;
import br.com.f1graphics.service.objects.SeasonsService;
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
public class SeasonsServiceImpl implements SeasonsService {

    private final DriversFacade driversFacade;

    private final RacesService racesService;


    private Double pointsChampionshipRaces = 0.0;
    private Double pointsChampionshipSprintRaces = 0.0;

    private static F1GraphicsFactory factory;

    @Override
    public SeaseonResponseDTO getSeasonForDriversIds(String season, ListDriversIdRequestDTO listDriversIds) {

        SeaseonResponseDTO seaseonResponseDTO = getSeasonResponse(season, listDriversIds);


        return seaseonResponseDTO;
    }



    private Map<String, Double> criarMapSeasonValorResult(List<RaceResponseDTO> listRace
            , List<String> listDriversId){
        Map<String, Double> mapSeasonValorResult = new HashMap<>();

        for(RaceResponseDTO race : listRace){
            for (String driverId: listDriversId){
                mapSeasonValorResult.put("totalSeasonPoints"+driverId,0.0);
                mapSeasonValorResult.put("racesSeasonPoints"+driverId,0.0);
                mapSeasonValorResult.put("sprintSeasonPoints"+driverId,0.0);
            }

        }

        return mapSeasonValorResult;
    }

    private ResultSeaseonResponseDTO getResultSeasonResponse(String raceName
            , Map<String, Double> mapSeasonValorResult, String DriverId) {


        return factory.createResultChampionshipResponse(raceName
                , mapSeasonValorResult.get("totalSeasonPoints"+DriverId)
                , mapSeasonValorResult.get("racesSeasonPoints"+DriverId)
                , mapSeasonValorResult.get("sprintSeasonPoints"+DriverId));
    }

    private SeaseonResponseDTO getSeasonResponse(String season, ListDriversIdRequestDTO listDriversIds) {

        List<RaceResponseDTO> listRace = racesService.getListRaces(season);
        List<String> listDriversIdsSting = listDriversIds.getListDriversIdRequestDTO();


        Map<String, RaceResponseDTO> mapRaceTable = getMapRaceResponse(season,listDriversIdsSting);
        Map<String, RaceSprintResponseDTO> mapRaceSprint = getMapRaceSprintResponse(season,listDriversIdsSting);
        List<RaceSeaseonResponseDTO> raceSesonResponse = getRaceSeasonResponseDTO(listRace,listDriversIdsSting
                ,mapRaceTable,mapRaceSprint);

        return factory.createChampionshipResponseDTO(season ,
            String.valueOf(listDriversIdsSting.size()), raceSesonResponse);
    }


    private Map<String, RaceResponseDTO> getMapRaceResponse(String season, List<String> listDriversIds){

        Map<String, RaceResponseDTO> mapRaceResponse = new HashMap<>();

        for (String driverId : listDriversIds) {
            List<RaceResponseDTO> listRaces =  racesService.getRaceTableForDriverId(season, driverId ).getRaces();
            for(RaceResponseDTO race : listRaces ){
                mapRaceResponse.put(driverId + race.getRaceName(), race);
            }
        }
        return mapRaceResponse;
    }

    private Map<String,RaceSprintResponseDTO> getMapRaceSprintResponse(String season, List<String> listDriversIds){

        Map<String,RaceSprintResponseDTO> mapRaceSprintResponse = new HashMap<>();

        for (String driverId : listDriversIds) {
            List<RaceSprintResponseDTO> listRaces =  racesService.getResultSpintRacesForDriverSeason(season, driverId ).getRaces();
            for(RaceSprintResponseDTO race : listRaces ){
                mapRaceSprintResponse.put(driverId + race.getRaceName(), race);
            }
        }
        return mapRaceSprintResponse;
    }


    private List<RaceSeaseonResponseDTO> getRaceSeasonResponseDTO(List<RaceResponseDTO> listRace, List<String> listDriversIds
            , Map<String, RaceResponseDTO> mapRaceTable, Map<String, RaceSprintResponseDTO> mapRaceSprint) {


        List<RaceSeaseonResponseDTO> listRaceSeaseon = new ArrayList<>();
        Map<String, Double> mapSeasonValorResult = criarMapSeasonValorResult(listRace,listDriversIds) ;

        for(RaceResponseDTO race: listRace) {

            Map<String ,DriverSeasonResponseDTO> driverListChampionsResponse = new HashMap<>();

            for(String driverId:listDriversIds){
                if (!driverListChampionsResponse.containsKey(driverId+race.getRaceName())){

                    RaceResponseDTO raceFilter = mapRaceTable.get(driverId+race.getRaceName());
                    RaceSprintResponseDTO raceSprintFilter = mapRaceSprint.get(driverId+race.getRaceName());

                    DriverSeasonResponseDTO  driverSeason =  getDriverSeasonResponseDTO(driverId, raceFilter, raceSprintFilter
                            , mapSeasonValorResult);
                    driverListChampionsResponse.put(driverId+race.getRaceName() ,driverSeason);
                }
            }

            RaceSeaseonResponseDTO raceSeaseonResponse = factory.createRaceChampionsResponseDTO(race
                    , race.getCircuit(),new ArrayList<>(driverListChampionsResponse.values()));
            listRaceSeaseon.add(raceSeaseonResponse);

        }
        return listRaceSeaseon;

    }

    private DriverSeasonResponseDTO getDriverSeasonResponseDTO(String driversId, RaceResponseDTO race
            , RaceSprintResponseDTO  raceSprint, Map<String, Double> mapSeasonValorResult) {

        Double racePoint = 0.0;
        Double totalRace = 0.0;
        Double newTotalRace = 0.0;

        Double sprintPoint = 0.0;
        Double totalRaceSprint = 0.0;
        Double newRaceSprint = 0.0;

        Double totalSeason = 0.0;
        Double newTotalSeason = 0.0;

        ResultSeaseonResponseDTO resultSeasonResponse = new ResultSeaseonResponseDTO();
        ResultRaceResponseDTO raceResponseDTO = new ResultRaceResponseDTO();


        if(race != null){
                racePoint = Double.valueOf(race.getResults().get(0).getPoints());
                totalRace = mapSeasonValorResult.get("totalSeasonPoints"+driversId);
                if(totalRace != null){
                    newTotalRace = totalRace + racePoint;
                    mapSeasonValorResult.replace("totalSeasonPoints"+driversId , newTotalRace);
                }
             if(raceSprint != null){
                sprintPoint = Double.valueOf(race.getResults().get(0).getPoints());
                totalRaceSprint = mapSeasonValorResult.get("sprintSeasonPoints"+driversId);
                newRaceSprint = totalRaceSprint + sprintPoint;
                mapSeasonValorResult.replace("sprintSeasonPoints"+driversId , newRaceSprint);
            }
            if(race != null && raceSprint != null){
                totalSeason = mapSeasonValorResult.get("totalSeasonPoints"+driversId);
                newTotalSeason = totalSeason + racePoint + sprintPoint;
                mapSeasonValorResult.replace("totalSeasonPoints"+driversId , newTotalSeason);
                            }

            resultSeasonResponse  =  getResultSeasonResponse(race.getRaceName(), mapSeasonValorResult
                , driversId);

            raceResponseDTO = getResultRaceResponseDTO(race.getResults().get(0));

                return factory.createDriverSeasonResponseDTO(race.getResults().get(0)
                        , raceResponseDTO
                        , resultSeasonResponse);
            }

        return null;

    }



    private ResultRaceResponseDTO getResultRaceResponseDTO(ResultResponseDTO resultRaceResponseDTO) {

        return factory.createResultRaceResponseDTO(resultRaceResponseDTO);
    }


}
