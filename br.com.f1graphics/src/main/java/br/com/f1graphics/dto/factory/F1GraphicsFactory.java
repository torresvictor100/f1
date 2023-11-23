package br.com.f1graphics.dto.factory;

import br.com.f1graphics.dto.request.*;
import br.com.f1graphics.dto.request.constructions.ConstructorRequestDTO;
import br.com.f1graphics.dto.request.races.RaceSprintRequestDTO;
import br.com.f1graphics.dto.request.racetable.RaceSprintTableRoundRequestDTO;
import br.com.f1graphics.dto.request.racetable.RaceTableDriverIdRequestDTO;
import br.com.f1graphics.dto.request.racetable.RaceTablePositionRequestDTO;
import br.com.f1graphics.dto.request.racetable.RaceTableRoundRequestDTO;
import br.com.f1graphics.dto.response.*;
import br.com.f1graphics.dto.response.drive.DriverResponseDTO;
import br.com.f1graphics.dto.response.drive.DriverSeasonResponseDTO;
import br.com.f1graphics.dto.response.races.RaceResponseDTO;
import br.com.f1graphics.dto.response.races.RaceSeaseonResponseDTO;
import br.com.f1graphics.dto.response.races.RaceSprintResponseDTO;
import br.com.f1graphics.dto.response.racestable.RaceSprintTableResponseDTO;
import br.com.f1graphics.dto.response.racestable.RaceTableResponseDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class F1GraphicsFactory {

    public static SeaseonResponseDTO createChampionshipResponseDTO(String season, String totalGPs, List<RaceSeaseonResponseDTO> raceChampions) {

        SeaseonResponseDTO championship = new SeaseonResponseDTO();
        validateAndSetIfNotNull(season, championship::setSeason);
        validateAndSetIfNotNull(totalGPs, championship::setTotalGPs);
        validateAndSetIfNotNull(raceChampions, championship::setRaceChampions);


        return championship;
    }

    public static LocationResponseDTO createLocationResponseDTO(LocationResponseDTO locationRequest) {

        LocationResponseDTO locationResponse = new LocationResponseDTO();

        validateAndSetIfNotNull(locationRequest.getLat(), locationResponse::setLat);
        validateAndSetIfNotNull(locationRequest.getLon(), locationResponse::setLon);
        validateAndSetIfNotNull(locationRequest.getLocality(), locationResponse::setLocality);
        validateAndSetIfNotNull(locationRequest.getCountry(), locationResponse::setCountry);


        return locationResponse;
    }

    public static RaceSeaseonResponseDTO createRaceChampionsResponseDTO(String round, String url, String raceName
            , String points, String laps, CircuitResponseDTO circuit, String date
            , String time, List<DriverSeasonResponseDTO> driversResults) {

        RaceSeaseonResponseDTO raceChampions = new RaceSeaseonResponseDTO();

        validateAndSetIfNotNull(round, raceChampions::setRound);
        validateAndSetIfNotNull(url, raceChampions::setUrl);
        validateAndSetIfNotNull(raceName, raceChampions::setRaceName);
        validateAndSetIfNotNull(laps, raceChampions::setLaps);
        validateAndSetIfNotNull(circuit, raceChampions::setCircuit);
        validateAndSetIfNotNull(date, raceChampions::setDate);
        validateAndSetIfNotNull(time, raceChampions::setTime);
        validateAndSetIfNotNull(driversResults, raceChampions::setDriversResults);


        return raceChampions;
    }


    public static CircuitResponseDTO createCircuitResponseDTO(CircuitResponseDTO circuitResponse) {


        validateAndSetIfNotNull(circuitResponse.getCircuitId(), circuitResponse::setCircuitId);
        validateAndSetIfNotNull(circuitResponse.getUrl(), circuitResponse::setUrl);
        validateAndSetIfNotNull(circuitResponse.getCircuitName(), circuitResponse::setCircuitName);
        validateAndSetIfNotNull(circuitResponse.getLocation(), location ->
                circuitResponse.setLocation(createLocationResponseDTO(location)));

        return circuitResponse;
    }

    public static List<br.com.f1graphics.dto.response.races.RaceResponseDTO> createListRaceResponseDTO(List<RaceResponseDTO> listRaceRequest) {

        List<br.com.f1graphics.dto.response.races.RaceResponseDTO> listRaceResponse = new ArrayList<>();

        for (RaceResponseDTO raceRequest : listRaceRequest) {

            br.com.f1graphics.dto.response.races.RaceResponseDTO raceResponse = new br.com.f1graphics.dto.response.races.RaceResponseDTO();

            validateAndSetIfNotNull(raceRequest.getSeason(), raceResponse::setSeason);
            validateAndSetIfNotNull(raceRequest.getRound(), raceResponse::setRound);
            validateAndSetIfNotNull(raceRequest.getUrl(), raceResponse::setUrl);
            validateAndSetIfNotNull(raceRequest.getRaceName(), raceResponse::setRaceName);
            validateAndSetIfNotNull(raceRequest.getCircuit(), circuit -> raceResponse.setCircuit(createCircuitResponseDTO(circuit)));
            validateAndSetIfNotNull(raceRequest.getDate(), raceResponse::setDate);
            validateAndSetIfNotNull(raceRequest.getTime(), raceResponse::setTime);
            validateAndSetIfNotNull(raceRequest.getResults(), results -> raceResponse.setResults(createResultsListResponseDTO(results)));

            listRaceResponse.add(raceResponse);
        }


        return listRaceResponse;
    }

    public static List<RaceSprintResponseDTO> createListRaceSprintResponseDTO(List<RaceSprintRequestDTO> listRaceSprintRequest) {

        List<RaceSprintResponseDTO> listRaceResponse = new ArrayList<>();

        for (RaceSprintRequestDTO raceRequest : listRaceSprintRequest) {

            RaceSprintResponseDTO raceResponse = new RaceSprintResponseDTO();

            validateAndSetIfNotNull(raceRequest.getSeason(), raceResponse::setSeason);
            validateAndSetIfNotNull(raceRequest.getRound(), raceResponse::setRound);
            validateAndSetIfNotNull(raceRequest.getUrl(), raceResponse::setUrl);
            validateAndSetIfNotNull(raceRequest.getRaceName(), raceResponse::setRaceName);
            validateAndSetIfNotNull(raceRequest.getCircuit(), circuit -> raceResponse.setCircuit(createCircuitResponseDTO(circuit)));
            validateAndSetIfNotNull(raceRequest.getDate(), raceResponse::setDate);
            validateAndSetIfNotNull(raceRequest.getTime(), raceResponse::setTime);
            validateAndSetIfNotNull(raceRequest.getSprintResults(), results -> raceResponse.setSprintResults(createResultsListResponseDTO(results)));

            listRaceResponse.add(raceResponse);
        }


        return listRaceResponse;
    }


    public static br.com.f1graphics.dto.response.races.RaceResponseDTO createRaceResponseDTO(RaceResponseDTO raceRequest) {

        br.com.f1graphics.dto.response.races.RaceResponseDTO raceResponse = new br.com.f1graphics.dto.response.races.RaceResponseDTO();

        validateAndSetIfNotNull(raceRequest.getSeason(), raceResponse::setSeason);
        validateAndSetIfNotNull(raceRequest.getRound(), raceResponse::setRound);
        validateAndSetIfNotNull(raceRequest.getUrl(), raceResponse::setUrl);
        validateAndSetIfNotNull(raceRequest.getRaceName(), raceResponse::setRaceName);
        validateAndSetIfNotNull(raceRequest.getCircuit(), circuit -> raceResponse.setCircuit(createCircuitResponseDTO(circuit)));
        validateAndSetIfNotNull(raceRequest.getDate(), raceResponse::setDate);
        validateAndSetIfNotNull(raceRequest.getTime(), raceResponse::setTime);
        validateAndSetIfNotNull(raceRequest.getResults(), results -> raceResponse.setResults(createResultsListResponseDTO(results)));

        return raceResponse;
    }

    public static RaceSprintResponseDTO createRaceSprintResponseDTO(RaceSprintRequestDTO raceRequest) {

        RaceSprintResponseDTO raceResponse = new RaceSprintResponseDTO();

        validateAndSetIfNotNull(raceRequest.getSeason(), raceResponse::setSeason);
        validateAndSetIfNotNull(raceRequest.getRound(), raceResponse::setRound);
        validateAndSetIfNotNull(raceRequest.getUrl(), raceResponse::setUrl);
        validateAndSetIfNotNull(raceRequest.getRaceName(), raceResponse::setRaceName);
        validateAndSetIfNotNull(raceRequest.getCircuit(), circuit -> raceResponse.setCircuit(createCircuitResponseDTO(circuit)));
        validateAndSetIfNotNull(raceRequest.getDate(), raceResponse::setDate);
        validateAndSetIfNotNull(raceRequest.getTime(), raceResponse::setTime);
        validateAndSetIfNotNull(raceRequest.getSprintResults(), results -> raceResponse.setSprintResults(createResultsListResponseDTO(results)));

        return raceResponse;
    }

    public static List<ResultResponseDTO> createResultsListResponseDTO(List<ResultResponseDTO> resultListRequest) {


        return resultListRequest;
    }

    public static ResultResponseDTO createResultsResponseDTO(ResultResponseDTO resultResponse) {

        return resultResponse;
    }

    public static FastestLapResponseDTO createFastestLapResponseDTO(FastestLapRequestDTO fastestLapRequest) {
        FastestLapResponseDTO fastestLapResponse = new FastestLapResponseDTO();

        validateAndSetIfNotNull(fastestLapRequest.getLap(), fastestLapResponse::setLap);
        validateAndSetIfNotNull(fastestLapRequest.getRank(), fastestLapResponse::setRank);
        validateAndSetIfNotNull(fastestLapRequest.getTime(), time ->
                fastestLapResponse.setTime(createTimeResponse(time)));
        validateAndSetIfNotNull(fastestLapRequest.getAverageSpeed(), averageSpeed ->
                fastestLapResponse.setAverageSpeed(createAverageSpeedResponseDTO(averageSpeed)));


        return fastestLapResponse;
    }

    public static AverageSpeedResponseDTO createAverageSpeedResponseDTO(AverageSpeedRequestDTO averageSpeedRequest) {

        AverageSpeedResponseDTO averageSpeedResponse = new AverageSpeedResponseDTO();

        validateAndSetIfNotNull(averageSpeedRequest.getSpeed(), averageSpeedResponse::setSpeed);
        validateAndSetIfNotNull(averageSpeedRequest.getUnits(), averageSpeedResponse::setUnits);


        return averageSpeedResponse;

    }

    public static ConstructorResponseDTO createConstructorResponse(ConstructorRequestDTO constructorRequest) {

        ConstructorResponseDTO constructorResponse = new ConstructorResponseDTO();

        validateAndSetIfNotNull(constructorRequest.getConstructorId(), constructorResponse::setConstructorId);
        validateAndSetIfNotNull(constructorRequest.getUrl(), constructorResponse::setUrl);
        validateAndSetIfNotNull(constructorRequest.getName(), constructorResponse::setName);
        validateAndSetIfNotNull(constructorRequest.getNationality(), constructorResponse::setNationality);


        return constructorResponse;
    }

    public static DriverResponseDTO createDriverResponse(DriverResponseDTO driverRequest) {
        DriverResponseDTO driverResponse = new DriverResponseDTO();

        validateAndSetIfNotNull(driverRequest.getDriverId(), driverResponse::setDriverId);
        validateAndSetIfNotNull(driverRequest.getUrl(), driverResponse::setUrl);
        validateAndSetIfNotNull(driverRequest.getGivenName(), driverResponse::setGivenName);
        validateAndSetIfNotNull(driverRequest.getFamilyName(), driverResponse::setFamilyName);
        validateAndSetIfNotNull(driverRequest.getDateOfBirth(), driverResponse::setDateOfBirth);
        validateAndSetIfNotNull(driverRequest.getNationality(), driverResponse::setNationality);


        return driverResponse;
    }

    public static TimeResponseDTO createTimeResponse(TimeRequestDTO timeRequest) {

        TimeResponseDTO timeResponse = new TimeResponseDTO();

        validateAndSetIfNotNull(timeRequest.getTime(), timeResponse::setTime);
        validateAndSetIfNotNull(timeRequest.getMillis(), timeResponse::setMillis);


        return timeResponse;

    }

    public static RaceTableResponseDTO createRaceTableResponseDTO(RaceTableDriverIdRequestDTO raceTableRequest) {

        RaceTableResponseDTO raceTableResponse = new RaceTableResponseDTO();

        validateAndSetIfNotNull(createListRaceResponseDTO(raceTableRequest.getRaces()), raceTableResponse::setRaces);
        validateAndSetIfNotNull(raceTableRequest.getSeason(), raceTableResponse::setSeason);
        validateAndSetIfNotNull(raceTableRequest.getDriverId(), raceTableResponse::setDriverId);


        return raceTableResponse;
    }

    public static RaceTableResponseDTO createRaceTableResponseDTO(RaceTableRoundRequestDTO raceTableRequest) {

        RaceTableResponseDTO raceTableResponse = new RaceTableResponseDTO();

        validateAndSetIfNotNull(createListRaceResponseDTO(raceTableRequest.getRaces()), raceTableResponse::setRaces);
        validateAndSetIfNotNull(raceTableRequest.getSeason(), raceTableResponse::setSeason);
        validateAndSetIfNotNull(raceTableRequest.getRound(), raceTableResponse::setRound);


        return raceTableResponse;
    }

    public static RaceSprintTableResponseDTO createRaceSprintTableResponseDTO(RaceSprintTableRoundRequestDTO raceSprintTableRequest) {

        RaceSprintTableResponseDTO raceTableResponse = new RaceSprintTableResponseDTO();

        validateAndSetIfNotNull(createListRaceSprintResponseDTO(raceSprintTableRequest.getRaces()), raceTableResponse::setRaces);
        validateAndSetIfNotNull(raceSprintTableRequest.getSeason(), raceTableResponse::setSeason);
        validateAndSetIfNotNull(raceSprintTableRequest.getRound(), raceTableResponse::setRound);


        return raceTableResponse;
    }

    public static RaceSeaseonResponseDTO createRaceChampionsResponseDTO(RaceResponseDTO raceResponseDTO
            , CircuitResponseDTO circuit, List<DriverSeasonResponseDTO> driversResults) {

        RaceSeaseonResponseDTO raceChampionsResponse = new RaceSeaseonResponseDTO();

        validateAndSetIfNotNull(raceResponseDTO.getRaceName(), raceChampionsResponse::setRaceName);
        validateAndSetIfNotNull(raceResponseDTO.getUrl(), raceChampionsResponse::setUrl);
        validateAndSetIfNotNull(raceResponseDTO.getRound(), raceChampionsResponse::setRound);
        validateAndSetIfNotNull(circuit, raceChampionsResponse::setCircuit);
        validateAndSetIfNotNull(raceResponseDTO.getDate(), raceChampionsResponse::setDate);
        validateAndSetIfNotNull(raceResponseDTO.getTime(), raceChampionsResponse::setTime);
        validateAndSetIfNotNull(driversResults, raceChampionsResponse::setDriversResults);

        return raceChampionsResponse;
    }

    public static RaceTableResponseDTO createRaceTableResponseDTO(RaceTablePositionRequestDTO raceTableRequest) {

        RaceTableResponseDTO raceTableResponse = new RaceTableResponseDTO();

        validateAndSetIfNotNull(createListRaceResponseDTO(raceTableRequest.getRaces()), raceTableResponse::setRaces);
        validateAndSetIfNotNull(raceTableRequest.getSeason(), raceTableResponse::setSeason);
        validateAndSetIfNotNull(raceTableRequest.getPosition(), raceTableResponse::setRound);


        return raceTableResponse;
    }


    public static DriverTableResponseDTO createDriverTableResponseDTO(DriverTableResponseDTO driverTableResponseDTO) {


        return driverTableResponseDTO;
    }

    public static DriverSeasonResponseDTO createDriverSeasonResponseDTO(ResultResponseDTO resultRequestDTO
            , ResultRaceResponseDTO resultRaceResponse, ResultSeaseonResponseDTO resultChampionshipResponse) {

        DriverSeasonResponseDTO driverChampionsResponse = new DriverSeasonResponseDTO();

        validateAndSetIfNotNull(resultRequestDTO.getDriver().getDriverId(), driverChampionsResponse::setDriverId);
        validateAndSetIfNotNull(resultRequestDTO.getConstructor(), driverChampionsResponse::setConstructor);
        validateAndSetIfNotNull(resultRequestDTO.getDriver().getUrl(), driverChampionsResponse::setUrl);
        validateAndSetIfNotNull(resultRequestDTO.getDriver().getGivenName(), driverChampionsResponse::setGivenName);
        validateAndSetIfNotNull(resultRequestDTO.getDriver().getDateOfBirth(), driverChampionsResponse::setDateOfBirth);
        validateAndSetIfNotNull(resultRequestDTO.getDriver().getNationality(), driverChampionsResponse::setNationality);

        driverChampionsResponse.setResultRaceResponse(resultRaceResponse);
        driverChampionsResponse.setResultChampionshipResponseDTO(resultChampionshipResponse);



        return driverChampionsResponse;
    }


    public static ResultRaceResponseDTO createResultRaceResponseDTO(ResultResponseDTO resultResponseDTO) {

        ResultRaceResponseDTO resultRaceResponse = new ResultRaceResponseDTO();

        validateAndSetIfNotNull(resultResponseDTO.getTime(), resultRaceResponse::setTime);
        validateAndSetIfNotNull(resultResponseDTO.getPoints(), resultRaceResponse::setPoints);
        validateAndSetIfNotNull(resultRaceResponse.getGrid(), resultRaceResponse::setGrid);
        validateAndSetIfNotNull(resultResponseDTO.getPosition(), resultRaceResponse::setPosition);
        validateAndSetIfNotNull(resultResponseDTO.getFastestLap(), resultRaceResponse::setFastestLap);

        return resultRaceResponse;
    }

    public static ResultSeaseonResponseDTO createResultChampionshipResponse(String raceName, Double pointsChampionship
            , Double pointsChampionshipRaces, Double pointsChampionshipSprintRaces) {

        ResultSeaseonResponseDTO resultChampionshipResponse = new ResultSeaseonResponseDTO();

        validateAndSetIfNotNull(raceName, resultChampionshipResponse::setRaceName);
        validateAndSetIfNotNull(pointsChampionship, resultChampionshipResponse::setPointsChampionship);
        validateAndSetIfNotNull(pointsChampionshipRaces, resultChampionshipResponse::setPointsChampionshipRaces);
        validateAndSetIfNotNull(pointsChampionshipSprintRaces, resultChampionshipResponse::setPointsChampionshipSprintRaces);

        return resultChampionshipResponse;
    }

    public static <T> void validateAndSetIfNotNull(T source, Consumer<T> setter) {
        if (source != null) {
            setter.accept(source);
        }
    }
}
