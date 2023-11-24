package br.com.f1graphics.service.objects;

import br.com.f1graphics.dto.response.RaceSprintTableRoundResponseDTO;
import br.com.f1graphics.dto.response.ListNamesRacesResponseDTO;
import br.com.f1graphics.dto.response.RaceTableDriverIdResponseDTO;
import br.com.f1graphics.dto.response.races.RaceResponseDTO;
import br.com.f1graphics.dto.response.racestable.RaceTableResponseDTO;

import java.util.List;

public interface RacesService {

    ListNamesRacesResponseDTO getListNamesRacesForSeason(String season);

    RaceSprintTableRoundResponseDTO getResultSpintRacesForDriverSeason(String season, String Id);

    RaceSprintTableRoundResponseDTO getRaceSprintTableForRound(String season, String round);

    RaceTableDriverIdResponseDTO getRaceTableForDriverId(String season, String driverId );

    public RaceResponseDTO getRaceResultsForRound(String season, int round);

    List<RaceResponseDTO> getListRaces(String season);
}
