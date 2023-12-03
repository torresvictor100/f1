package br.com.f1graphics.service.impl;

import br.com.f1graphics.dto.factory.F1GraphicsFactory;
import br.com.f1graphics.dto.request.ListDriversIdRequestDTO;
import br.com.f1graphics.dto.response.DriverPointsResponseDTO;
import br.com.f1graphics.dto.response.ListNamesRacesResponseDTO;
import br.com.f1graphics.dto.response.SeasonResponseDTO;
import br.com.f1graphics.dto.response.drive.DriverSeasonResponseDTO;
import br.com.f1graphics.dto.response.races.RaceResponseDTO;
import br.com.f1graphics.dto.response.races.RaceSeasonResponseDTO;
import br.com.f1graphics.dto.response.races.RaceSprintResponseDTO;
import br.com.f1graphics.dto.response.results.ResultRaceResponseDTO;
import br.com.f1graphics.dto.response.results.ResultResponseDTO;
import br.com.f1graphics.dto.response.results.ResultSeasonResponseDTO;
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


    private final RacesService racesService;

    private static F1GraphicsFactory factory;

    private Map<String, DriverPointsResponseDTO> driverPointsResponseMap = new HashMap<>();

    @Override
    public SeasonResponseDTO getSeasonForDriversIds(String season, ListDriversIdRequestDTO listDriversIds) {


        return getSeasonResponse(season, listDriversIds);
    }

    private List<DriverPointsResponseDTO> getResultDriversPoints(ListDriversIdRequestDTO listDriversIds){
        List<DriverPointsResponseDTO> driverPointsList = new ArrayList<>();

        for (String driversIds: listDriversIds.getListDriversIdRequestDTO()){
            driverPointsList.add(driverPointsResponseMap.get(driversIds));

        }

        return driverPointsList;
    }

    private Double getTheLastResultDriverPointsForDriverId(String driverId){
        List<DriverPointsResponseDTO> driverPointsList = new ArrayList<>();

        int i = driverPointsResponseMap.get(driverId).getData().size();

        Double lastPoints = driverPointsResponseMap.get(driverId).getData().get(i-1);

        return lastPoints;
    }


    private Map<String, Double> createMapSeasonValorResult(List<String> listDriversId){
        Map<String, Double> mapSeasonValorResult = new HashMap<>();

        for (String driverId: listDriversId){

            DriverPointsResponseDTO  driverPoints = new DriverPointsResponseDTO();
            driverPoints.setName(driverId);
            List<Double> dataClean = new ArrayList<>();
            dataClean.add(0.0);
            driverPoints.setData(dataClean);
            driverPointsResponseMap.put(driverId, driverPoints);

            mapSeasonValorResult.put("totalSeasonPoints"+driverId,0.0);
            mapSeasonValorResult.put("racesSeasonPoints"+driverId,0.0);
            mapSeasonValorResult.put("sprintSeasonPoints"+driverId,0.0);
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
        ListNamesRacesResponseDTO listNamesRacesResponseDTO =  getListNamesRacesResponseDTO(listRace);
        List<String> listDriversIdsSting = listDriversIds.getListDriversIdRequestDTO();


        Map<String, RaceResponseDTO> mapRaceTable = getMapRaceResponse(season,listDriversIdsSting);
        Map<String, RaceSprintResponseDTO> mapRaceSprint = getMapRaceSprintResponse(season,listDriversIdsSting);
        List<RaceSeasonResponseDTO> raceSeasonResponse = getRaceSeasonResponseDTO(listRace,listDriversIdsSting
                ,mapRaceTable,mapRaceSprint);

        List<DriverPointsResponseDTO> driverPointList = getResultDriversPoints(listDriversIds);



        return factory.createSeaseonResponse(season ,
            String.valueOf(listRace.size()), raceSeasonResponse, driverPointList, listNamesRacesResponseDTO);
    }

    private ListNamesRacesResponseDTO getListNamesRacesResponseDTO(List<RaceResponseDTO> listRace ){

        ListNamesRacesResponseDTO listNamesRacesResponseDTO =  new ListNamesRacesResponseDTO();
        List<String> listNameRace = new ArrayList<>();
        listNameRace.add("");
        for(RaceResponseDTO raceResponseDTO : listRace){
            listNameRace.add(raceResponseDTO.getRaceName());
        }
        listNamesRacesResponseDTO.setListNamesRacesDTO(listNameRace);
        return listNamesRacesResponseDTO;
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
        Map<String, Double> mapSeasonValorResult = createMapSeasonValorResult(listDriversIds) ;

        for(RaceResponseDTO race: listRace) {

            Map<String ,DriverSeasonResponseDTO> driverListSeasonResponse = new HashMap<>();

            for(String driverId:listDriversIds){
                    if(mapRaceTable.containsKey(driverId+race.getRaceName())){
                        RaceResponseDTO raceFilter = mapRaceTable.get(driverId+race.getRaceName());
                        RaceSprintResponseDTO raceSprintFilter = mapRaceSprint.get(driverId+race.getRaceName());

                        DriverSeasonResponseDTO  driverSeason =  getDriverSeasonResponseDTO(driverId, raceFilter, raceSprintFilter
                                , mapSeasonValorResult);
                        driverListSeasonResponse.put(driverId+race.getRaceName() ,driverSeason);
                    }else {
                        setDriverPointsResponseMap(driverId, getTheLastResultDriverPointsForDriverId(driverId));
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


            setDriverPointsResponseMap(driversId,totalSeason);


        }else if(race != null) {

            Double racePoint = Double.valueOf(race.getResults().get(0).getPoints());

            Double totalSeason = mapSeasonValorResult.get("totalSeasonPoints" + driversId);
            Double totalRace = mapSeasonValorResult.get("racesSeasonPoints" + driversId);

            Double newTotalRace = totalRace + racePoint;
            mapSeasonValorResult.replace("racesSeasonPoints" + driversId, newTotalRace);

            totalSeason = totalSeason + racePoint ;
            mapSeasonValorResult.replace("totalSeasonPoints" + driversId, totalSeason);

            setDriverPointsResponseMap(driversId,totalSeason);
        }else if(raceSprint != null) {

            Double sprintPoint = Double.valueOf(raceSprint.getSprintResults().get(0).getPoints());

            Double totalSeason = mapSeasonValorResult.get("totalSeasonPoints" + driversId);
            Double totalRaceSprint = mapSeasonValorResult.get("sprintSeasonPoints" + driversId);

            Double newRaceSprint = totalRaceSprint + sprintPoint;
            mapSeasonValorResult.replace("sprintSeasonPoints" + driversId, newRaceSprint);

            totalSeason = totalSeason + sprintPoint;
            mapSeasonValorResult.replace("totalSeasonPoints" + driversId, totalSeason);

            setDriverPointsResponseMap(driversId,totalSeason);

        }
            if(race != null){
                ResultRaceResponseDTO raceResponse = getResultRaceResponseDTO(race.getResults().get(0));
                ResultSeasonResponseDTO resultSeasonResponse  =  getResultSeasonResponse(race.getRaceName(), mapSeasonValorResult, driversId);
                return factory.createDriverSeasonResponseDTO(race.getResults().get(0)
                        , raceResponse
                        , resultSeasonResponse);
            }
            return null;
    }

    private void setDriverPointsResponseMap(String driversId, Double totalSeason){

        DriverPointsResponseDTO driverPointsResponse = driverPointsResponseMap.get(driversId);

        List<Double> data;
        if(driverPointsResponse == null){
            data = new ArrayList<>();
            data.add(totalSeason);
        }else {
            data = driverPointsResponse.getData();
            data.add(totalSeason);
        }
        driverPointsResponse.setData(data);

        driverPointsResponseMap.replace(driversId, driverPointsResponse);
    }

    private ResultRaceResponseDTO getResultRaceResponseDTO(ResultResponseDTO resultRaceResponseDTO) {

        return factory.createResultRaceResponseDTO(resultRaceResponseDTO);
    }


}
