package br.com.f1graphics.dto.factory;

import br.com.f1graphics.dto.request.*;
import br.com.f1graphics.dto.request.constructions.ConstructorRequestDTO;
import br.com.f1graphics.dto.request.races.RaceSprintRequestDTO;
import br.com.f1graphics.dto.response.RaceSprintTableRoundResponseDTO;
import br.com.f1graphics.dto.response.RaceTableDriverIdResponseDTO;
import br.com.f1graphics.dto.request.racetable.RaceTablePositionRequestDTO;
import br.com.f1graphics.dto.request.racetable.RaceTableRoundRequestDTO;
import br.com.f1graphics.dto.response.*;
import br.com.f1graphics.dto.response.drive.DriverResponseDTO;
import br.com.f1graphics.dto.response.drive.DriverSeasonResponseDTO;
import br.com.f1graphics.dto.response.races.RaceResponseDTO;
import br.com.f1graphics.dto.response.races.RaceSeasonResponseDTO;
import br.com.f1graphics.dto.response.races.RaceSprintResponseDTO;
import br.com.f1graphics.dto.response.racestable.RaceSprintTableResponseDTO;
import br.com.f1graphics.dto.response.racestable.RaceTableResponseDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class F1GraphicsFactory {

    public static SeasonResponseDTO createSeaseonResponse(String season, String totalGPs, List<RaceSeasonResponseDTO> listRaceSeaseon) {

        SeasonResponseDTO seasonResponse = new SeasonResponseDTO();
        validateAndSetIfNotNull(season, seasonResponse::setSeason);
        validateAndSetIfNotNull(totalGPs, seasonResponse::setTotalGPs);
        validateAndSetIfNotNull(listRaceSeaseon, seasonResponse::setRaceSeason);


        return seasonResponse;
    }



    public static RaceSeasonResponseDTO createRaceSeasonResponse(RaceResponseDTO raceResponseDTO
            , CircuitResponseDTO circuit, List<DriverSeasonResponseDTO> driversResults) {

        RaceSeasonResponseDTO raceSeasonResponse = new RaceSeasonResponseDTO();

        validateAndSetIfNotNull(raceResponseDTO.getRaceName(), raceSeasonResponse::setRaceName);
        validateAndSetIfNotNull(raceResponseDTO.getUrl(), raceSeasonResponse::setUrl);
        validateAndSetIfNotNull(raceResponseDTO.getRound(), raceSeasonResponse::setRound);
        validateAndSetIfNotNull(circuit, raceSeasonResponse::setCircuit);
        validateAndSetIfNotNull(raceResponseDTO.getDate(), raceSeasonResponse::setDate);
        validateAndSetIfNotNull(raceResponseDTO.getTime(), raceSeasonResponse::setTime);
        validateAndSetIfNotNull(driversResults, raceSeasonResponse::setDriversResults);

        return raceSeasonResponse;
    }



    public static DriverSeasonResponseDTO createDriverSeasonResponseDTO(ResultResponseDTO resultRequestDTO
            , ResultRaceResponseDTO resultRaceResponse, ResultSeasonResponseDTO resultSeasonResponse) {

        DriverSeasonResponseDTO driverSeasonResponse = new DriverSeasonResponseDTO();

        validateAndSetIfNotNull(resultRequestDTO.getDriver().getDriverId(), driverSeasonResponse::setDriverId);
        validateAndSetIfNotNull(resultRequestDTO.getConstructor(), driverSeasonResponse::setConstructor);
        validateAndSetIfNotNull(resultRequestDTO.getDriver().getUrl(), driverSeasonResponse::setUrl);
        validateAndSetIfNotNull(resultRequestDTO.getDriver().getGivenName(), driverSeasonResponse::setGivenName);
        validateAndSetIfNotNull(resultRequestDTO.getDriver().getDateOfBirth(), driverSeasonResponse::setDateOfBirth);
        validateAndSetIfNotNull(resultRequestDTO.getDriver().getNationality(), driverSeasonResponse::setNationality);

        driverSeasonResponse.setResultRaceResponse(resultRaceResponse);
        driverSeasonResponse.setResultSeaseonResponseDTO(resultSeasonResponse);



        return driverSeasonResponse;
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

    public static ResultSeasonResponseDTO createResultSeasonResponse(String raceName, Double pointsSeason
            , Double pointsSeasonRaces, Double pointsSeasonSprintRaces) {

        ResultSeasonResponseDTO resultSeasonResponse = new ResultSeasonResponseDTO();

        validateAndSetIfNotNull(raceName, resultSeasonResponse::setRaceName);
        validateAndSetIfNotNull(pointsSeason, resultSeasonResponse::setPointsSeason);
        validateAndSetIfNotNull(pointsSeasonRaces, resultSeasonResponse::setPointsSeasonRaces);
        validateAndSetIfNotNull(pointsSeasonSprintRaces, resultSeasonResponse::setPointsSeasonSprintRaces);

        return resultSeasonResponse;
    }

    public static <T> void validateAndSetIfNotNull(T source, Consumer<T> setter) {
        if (source != null) {
            setter.accept(source);
        }
    }
}
