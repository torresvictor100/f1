package br.com.f1graphics.service.impl;

import br.com.f1graphics.dto.factory.F1GraphicsFactory;
import br.com.f1graphics.dto.request.ListDriversIdRequestDTO;
import br.com.f1graphics.dto.response.results.ResultRaceResponseDTO;
import br.com.f1graphics.dto.response.results.ResultResponseDTO;
import br.com.f1graphics.dto.response.results.ResultSeasonResponseDTO;
import br.com.f1graphics.dto.response.SeasonResponseDTO;
import br.com.f1graphics.dto.response.drive.DriverSeasonResponseDTO;
import br.com.f1graphics.dto.response.races.RaceResponseDTO;
import br.com.f1graphics.dto.response.races.RaceSeasonResponseDTO;
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


    private static F1GraphicsFactory factory;

    @Override
    public SeasonResponseDTO getSeasonForDriversIds(String season, ListDriversIdRequestDTO listDriversIds) {

        SeasonResponseDTO seaseonResponseDTO = getSeasonResponse(season, listDriversIds);


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

    private ResultSeasonResponseDTO getResultSeasonResponse(String raceName
            , Map<String, Double> mapSeasonValorResult, String DriverId) {


        return factory.createResultSeasonResponse(raceName
                , mapSeasonValorResult.get("totalSeasonPoints"+DriverId)
                , mapSeasonValorResult.get("racesSeasonPoints"+DriverId)
                , mapSeasonValorResult.get("sprintSeasonPoints"+DriverId));
    }

    private SeasonResponseDTO getSeasonResponse(String season, ListDriversIdRequestDTO listDriversIds) {

        List<RaceResponseDTO> listRace = racesService.getListRaces(season);
        List<String> listDriversIdsSting = listDriversIds.getListDriversIdRequestDTO();


        Map<String, RaceResponseDTO> mapRaceTable = getMapRaceResponse(season,listDriversIdsSting);
        Map<String, RaceSprintResponseDTO> mapRaceSprint = getMapRaceSprintResponse(season,listDriversIdsSting);
        List<RaceSeasonResponseDTO> raceSeasonResponse = getRaceSeasonResponseDTO(listRace,listDriversIdsSting
                ,mapRaceTable,mapRaceSprint);

        return factory.createSeaseonResponse(season ,
            String.valueOf(listRace.size()), raceSeasonResponse);
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


    private List<RaceSeasonResponseDTO> getRaceSeasonResponseDTO(List<RaceResponseDTO> listRace, List<String> listDriversIds
            , Map<String, RaceResponseDTO> mapRaceTable, Map<String, RaceSprintResponseDTO> mapRaceSprint) {


        List<RaceSeasonResponseDTO> listRaceSeaseon = new ArrayList<>();
        Map<String, Double> mapSeasonValorResult = criarMapSeasonValorResult(listRace,listDriversIds) ;

        for(RaceResponseDTO race: listRace) {

            Map<String ,DriverSeasonResponseDTO> driverListSeasonResponse = new HashMap<>();

            for(String driverId:listDriversIds){
                if (!driverListSeasonResponse.containsKey(driverId+race.getRaceName())){

                    RaceResponseDTO raceFilter = mapRaceTable.get(driverId+race.getRaceName());
                    RaceSprintResponseDTO raceSprintFilter = mapRaceSprint.get(driverId+race.getRaceName());

                    DriverSeasonResponseDTO  driverSeason =  getDriverSeasonResponseDTO(driverId, raceFilter, raceSprintFilter
                            , mapSeasonValorResult);
                    driverListSeasonResponse.put(driverId+race.getRaceName() ,driverSeason);
                }
            }

            RaceSeasonResponseDTO raceSeaseonResponse = factory.createRaceSeasonResponse(race
                    , race.getCircuit(),new ArrayList<>(driverListSeasonResponse.values()));
            listRaceSeaseon.add(raceSeaseonResponse);

        }
        return listRaceSeaseon;

    }

    private DriverSeasonResponseDTO getDriverSeasonResponseDTO(String driversId, RaceResponseDTO race
            , RaceSprintResponseDTO  raceSprint, Map<String, Double> mapSeasonValorResult) {


        ResultSeasonResponseDTO resultSeasonResponse = new ResultSeasonResponseDTO();
        ResultRaceResponseDTO raceResponseDTO = new ResultRaceResponseDTO();


        if(race != null && raceSprint != null) {

            Double racePoint = Double.valueOf(race.getResults().get(0).getPoints());
            Double sprintPoint = Double.valueOf(raceSprint.getSprintResults().get(0).getPoints());

            Double totalSeason = mapSeasonValorResult.get("totalSeasonPoints" + driversId);
            Double totalRace = mapSeasonValorResult.get("racesSeasonPoints" + driversId);
            Double totalRaceSprint = mapSeasonValorResult.get("sprintSeasonPoints" + driversId);



            Double newRaceSprint = totalRaceSprint + sprintPoint;
            mapSeasonValorResult.replace("sprintSeasonPoints" + driversId, newRaceSprint);

            Double newTotalRace = totalRace + racePoint;
            mapSeasonValorResult.replace("racesSeasonPoints" + driversId, newTotalRace);

            totalSeason = totalSeason + racePoint + sprintPoint;
            mapSeasonValorResult.replace("totalSeasonPoints" + driversId, totalSeason);
        }else if(race != null && raceSprint == null) {

            Double racePoint = Double.valueOf(race.getResults().get(0).getPoints());

            Double totalSeason = mapSeasonValorResult.get("totalSeasonPoints" + driversId);
            Double totalRace = mapSeasonValorResult.get("racesSeasonPoints" + driversId);

            Double newTotalRace = totalRace + racePoint;
            mapSeasonValorResult.replace("racesSeasonPoints" + driversId, newTotalRace);

            totalSeason = totalSeason + racePoint ;
            mapSeasonValorResult.replace("totalSeasonPoints" + driversId, totalSeason);
        }else if(race == null && raceSprint != null) {

            Double sprintPoint = Double.valueOf(raceSprint.getSprintResults().get(0).getPoints());

            Double totalSeason = mapSeasonValorResult.get("totalSeasonPoints" + driversId);
            Double totalRaceSprint = mapSeasonValorResult.get("sprintSeasonPoints" + driversId);



            Double newRaceSprint = totalRaceSprint + sprintPoint;
            mapSeasonValorResult.replace("sprintSeasonPoints" + driversId, newRaceSprint);


            totalSeason = totalSeason + sprintPoint;
            mapSeasonValorResult.replace("totalSeasonPoints" + driversId, totalSeason);


        }

            raceResponseDTO = getResultRaceResponseDTO(race.getResults().get(0));
            resultSeasonResponse  =  getResultSeasonResponse(race.getRaceName(), mapSeasonValorResult, driversId);
            return factory.createDriverSeasonResponseDTO(race.getResults().get(0)
                        , raceResponseDTO
                        , resultSeasonResponse);
    }





    private ResultRaceResponseDTO getResultRaceResponseDTO(ResultResponseDTO resultRaceResponseDTO) {

        return factory.createResultRaceResponseDTO(resultRaceResponseDTO);
    }


}
