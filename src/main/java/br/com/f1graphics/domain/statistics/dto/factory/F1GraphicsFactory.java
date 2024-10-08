package br.com.f1graphics.domain.statistics.dto.factory;

import br.com.f1graphics.domain.statistics.dto.response.CircuitResponseDTO;
import br.com.f1graphics.domain.statistics.dto.response.DriverPointsResponseDTO;
import br.com.f1graphics.domain.statistics.dto.response.ListNamesRacesResponseDTO;
import br.com.f1graphics.domain.statistics.dto.response.SeasonResponseDTO;
import br.com.f1graphics.domain.statistics.dto.response.drive.DriverSeasonResponseDTO;
import br.com.f1graphics.domain.statistics.dto.response.races.RaceResponseDTO;
import br.com.f1graphics.domain.statistics.dto.response.races.RaceSeasonResponseDTO;
import br.com.f1graphics.domain.statistics.dto.response.results.ResultRaceResponseDTO;
import br.com.f1graphics.domain.statistics.dto.response.results.ResultResponseDTO;
import br.com.f1graphics.domain.statistics.dto.response.results.ResultSeasonResponseDTO;

import java.util.List;
import java.util.function.Consumer;

public class F1GraphicsFactory {

    public static SeasonResponseDTO createSeaseonResponse(String season, String totalGPs, List<RaceSeasonResponseDTO> listRaceSeaseon
            , List<DriverPointsResponseDTO> driverPointList, ListNamesRacesResponseDTO listNamesRacesResponseDTO ) {

        SeasonResponseDTO seasonResponse = new SeasonResponseDTO();
        validateAndSetIfNotNull(season, seasonResponse::setSeason);
        validateAndSetIfNotNull(totalGPs, seasonResponse::setTotalGPs);
        validateAndSetIfNotNull(listRaceSeaseon, seasonResponse::setRaceSeason);
        seasonResponse.setDriverPoints(driverPointList);
        seasonResponse.setListNamesRacesResponseDTO(listNamesRacesResponseDTO);


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
