package br.com.f1graphics.service.objects;

import br.com.f1graphics.dto.request.RaceTableRoundRequestDTO;
import br.com.f1graphics.dto.response.ListNamesRacesResponseDTO;
import br.com.f1graphics.dto.response.RaceTableResponseDTO;

public interface RacesService {

    ListNamesRacesResponseDTO getListNamesRacesForSeason(String season);

    RaceTableResponseDTO getResultSpintRacesForDriverSeason(String season, String Id);

    RaceTableResponseDTO getResultSpintRaces(String season, String round);


}
