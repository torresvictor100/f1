package br.com.f1graphics.dto.factory;

import br.com.f1graphics.dto.request.*;
import br.com.f1graphics.dto.response.*;

import java.util.ArrayList;
import java.util.List;

public class F1GraphicsFactory {

    public static ChampionshipResponseDTO createChampionshipResponseDTO(String season){

         ChampionshipResponseDTO championship = new ChampionshipResponseDTO();
         championship.setSeason(season);

        return championship;
    }

    public static LocationResponseDTO createLocationResponseDTO(LocationRequestDTO locationRequest){

        LocationResponseDTO locationResponse = new LocationResponseDTO();

        locationResponse.setLat(locationRequest.getLat());
        locationResponse.setLon(locationRequest.getLon());
        locationResponse.setLocality(locationRequest.getLocality());
        locationResponse.setCountry(locationRequest.getCountry());

        return locationResponse;
    }

    public static CircuitResponseDTO createCircuitResponseDTO(CircuitRequestDTO circuitRequest){

        CircuitResponseDTO circuitResponse = new CircuitResponseDTO();

        circuitResponse.setCircuitId(circuitRequest.getCircuitId());
        circuitResponse.setUrl(circuitResponse.getUrl());
        circuitResponse.setCircuitName(circuitResponse.getCircuitName());
        circuitResponse.setLocation(
                createLocationResponseDTO(circuitRequest.getLocation())
        );

        return circuitResponse;
    }

    public static List<RaceResponseDTO> createListRaceResponseDTO(List<RaceRequestDTO> listRaceRequest){

        List<RaceResponseDTO> listRaceResponse = new ArrayList<>();

        for (RaceRequestDTO raceRequest : listRaceRequest){

            RaceResponseDTO raceResponse = new RaceResponseDTO();

            raceResponse.setSeason(raceRequest.getSeason());
            raceResponse.setRound(raceRequest.getRound());
            raceResponse.setUrl(raceRequest.getUrl());
            raceResponse.setRaceName(raceRequest.getRaceName());
            raceResponse.setCircuit(createCircuitResponseDTO(raceRequest.getCircuit()));
            raceResponse.setDate(raceRequest.getDate());
            raceResponse.setTime(raceRequest.getTime());
            raceResponse.setResults(createResultsResponseDTO(raceRequest.getResults()));

            listRaceResponse.add(raceResponse);
        }



        return listRaceResponse;
    }

    public static List<ResultRequestDTO> createResultsResponseDTO(List<ResultRequestDTO> resultRequest){
        ResultResponseDTO resultResponse = new ResultResponseDTO();



    return null;
    }

    public static RaceTableResponseDTO createRaceTableResponseDTO(RaceTableDriverIdRequestDTO raceTableRequest){

        RaceTableResponseDTO raceTableResponse = new RaceTableResponseDTO();

        raceTableResponse.setRaces(createListRaceResponseDTO(raceTableRequest.getRaces()));
        raceTableResponse.setSeason(raceTableRequest.getSeason());
        raceTableResponse.setDriverId(raceTableRequest.getDriverId());
        return raceTableResponse;
    }

    public static RaceTableResponseDTO createRaceTableResponseDTO(RaceTableRoundRequestDTO raceTableRequest){

        RaceTableResponseDTO raceTableResponse = new RaceTableResponseDTO();

        raceTableResponse.setRaces(createListRaceResponseDTO(raceTableRequest.getRaces()));
        raceTableResponse.setSeason(raceTableRequest.getSeason());
        raceTableResponse.setRound(raceTableRequest.getRound());
        return raceTableResponse;
    }

    public static RaceTableResponseDTO createRaceTableResponseDTO(RaceTablePositionRequestDTO raceTableRequest){

        RaceTableResponseDTO raceTableResponse = new RaceTableResponseDTO();

        raceTableResponse.setRaces(createListRaceResponseDTO(raceTableRequest.getRaces()));
        raceTableResponse.setSeason(raceTableRequest.getSeason());
        raceTableResponse.setRound(raceTableRequest.getPosition());
        return raceTableResponse;
    }
}
