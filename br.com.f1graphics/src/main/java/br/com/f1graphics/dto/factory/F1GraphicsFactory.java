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
            raceResponse.setResults(createResultsListResponseDTO(raceRequest.getResults()));

            listRaceResponse.add(raceResponse);
        }



        return listRaceResponse;
    }

    public static List<ResultResponseDTO> createResultsListResponseDTO(List<ResultRequestDTO> resultListRequest){

        List<ResultResponseDTO> resultListResponse = new ArrayList<>();

        for (ResultRequestDTO resultRequest : resultListRequest){

            ResultResponseDTO resultResponse = new ResultResponseDTO();


            resultResponse.setLaps(resultRequest.getLaps());
            resultResponse.setGrid(resultRequest.getGrid());
            resultResponse.setNumber(resultRequest.getNumber());
            resultResponse.setPosition(resultRequest.getPosition());
            resultResponse.setPositionText(resultRequest.getPositionText());
            resultResponse.setPoints(resultRequest.getPoints());
            resultResponse.setStatus(resultRequest.getStatus());
            resultResponse.setDriver(createDriverResponse(resultRequest.getDriver()));
            resultResponse.setConstructor(createConstructorResponse(resultRequest.getConstructor()));
            resultResponse.setTime(createTimeResponse(resultRequest.getTime()));
            resultResponse.setFastestLap(createFastestLapResponseDTO(resultRequest.getFastestLap()));


            resultListResponse.add(resultResponse);

        }

    return resultListResponse;
    }

    public static FastestLapResponseDTO createFastestLapResponseDTO(FastestLapRequestDTO fastestLapRequest){
        FastestLapResponseDTO fastestLapResponse = new FastestLapResponseDTO();
        fastestLapResponse.setLap(fastestLapRequest.getLap());
        fastestLapResponse.setLap(fastestLapRequest.getLap());
        fastestLapResponse.setTime(createTimeResponse(fastestLapRequest.getTime()));
        fastestLapResponse.setAverageSpeed(createAverageSpeedResponseDTO(fastestLapRequest.getAverageSpeed()));

        return fastestLapResponse;
    }

    public static AverageSpeedResponseDTO createAverageSpeedResponseDTO(AverageSpeedRequestDTO averageSpeedRequest){

        AverageSpeedResponseDTO averageSpeedResponse = new AverageSpeedResponseDTO();

        averageSpeedResponse.setSpeed(averageSpeedRequest.getSpeed());
        averageSpeedResponse.setUnits(averageSpeedRequest.getUnits());

        return averageSpeedResponse;

    }

    public static ConstructorResponseDTO createConstructorResponse(ConstructorRequestDTO constructorRequest){

        ConstructorResponseDTO constructorResponse = new ConstructorResponseDTO();

        constructorResponse.setConstructorId(constructorRequest.getConstructorId());
        constructorResponse.setUrl(constructorRequest.getUrl());
        constructorResponse.setName(constructorRequest.getName());
        constructorResponse.setNationality(constructorRequest.getNationality());

        return constructorResponse;
    }

    public static DriverResponseDTO createDriverResponse(DriverRequestDTO driverRequest){
        DriverResponseDTO driverResponse = new DriverResponseDTO();

        driverResponse.setDriverId(driverRequest.getDriverId());
        driverResponse.setUrl(driverRequest.getUrl());
        driverResponse.setGivenName(driverRequest.getGivenName());
        driverResponse.setFamilyName(driverRequest.getFamilyName());
        driverResponse.setDateOfBirth(driverRequest.getDateOfBirth());
        driverResponse.setNationality(driverRequest.getNationality());

        return driverResponse;
    }

    public static TimeResponseDTO createTimeResponse(TimeRequestDTO timeRequest){

        TimeResponseDTO timeResponse = new TimeResponseDTO();

        timeResponse.setTime(timeRequest.getTime());
        timeResponse.setMillis(timeRequest.getTime());

        return timeResponse;

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

    public static DriverTableResponseDTO createDriverTableResponseDTO(DriverTableRequestDTO driverTableRequest){

        DriverTableResponseDTO driverTableResponse = new DriverTableResponseDTO();
        List<DriverResponseDTO> driverResponseList = new ArrayList<>();

        for(DriverRequestDTO driverRequest:driverTableRequest.getDrivers()){
            driverResponseList.add(createDriverResponse(driverRequest));
        }
        driverTableResponse.setDrivers(driverResponseList);

        return driverTableResponse;
    }
}
