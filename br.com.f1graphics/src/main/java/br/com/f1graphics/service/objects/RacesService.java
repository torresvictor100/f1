package br.com.f1graphics.service.objects;

import br.com.f1graphics.dto.response.ListNamesRacesResponseDTO;
import br.com.f1graphics.dto.response.races.RaceResponseDTO;
import br.com.f1graphics.dto.response.racestable.RaceSprintTableResponseDTO;
import br.com.f1graphics.dto.response.racestable.RaceTableResponseDTO;

public interface RacesService {

    ListNamesRacesResponseDTO getListNamesRacesForSeason(String season);

    RaceSprintTableResponseDTO getResultSpintRacesForDriverSeason(String season, String Id);

    RaceSprintTableResponseDTO getRaceSprintTableForRound(String season, String round);

    RaceTableResponseDTO getRaceTableForDriverId(String season, String driverId );

    public RaceResponseDTO getRaceResultsForRound(String season, int round);
}
