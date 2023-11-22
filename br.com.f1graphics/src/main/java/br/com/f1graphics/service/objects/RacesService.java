package br.com.f1graphics.service.objects;

import br.com.f1graphics.dto.request.RaceSprintTableRequestDTO;
import br.com.f1graphics.dto.request.RaceTableRoundRequestDTO;
import br.com.f1graphics.dto.response.ListNamesRacesResponseDTO;
import br.com.f1graphics.dto.response.RaceResponseDTO;
import br.com.f1graphics.dto.response.RaceSprintTableResponseDTO;
import br.com.f1graphics.dto.response.RaceTableResponseDTO;

public interface RacesService {

    ListNamesRacesResponseDTO getListNamesRacesForSeason(String season);

    RaceSprintTableResponseDTO getResultSpintRacesForDriverSeason(String season, String Id);

    RaceSprintTableResponseDTO getResultSpintRaces(String season, String round);

    RaceTableResponseDTO getDriverResultsForDriverId(String driverId, String driver );

    public RaceResponseDTO getRaceResultsForRound(String season, int round);
}
