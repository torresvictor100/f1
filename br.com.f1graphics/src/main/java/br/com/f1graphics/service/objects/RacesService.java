package br.com.f1graphics.service.objects;

import br.com.f1graphics.dto.request.RaceTableRoundRequestDTO;
import br.com.f1graphics.dto.response.ListNamesRacesResponseDTO;

public interface RacesService {

    ListNamesRacesResponseDTO getListNamesRacesForSeason(String season);

    RaceTableRoundRequestDTO getResultSpintRacesForDriverSeason(String season, String Id);


}
