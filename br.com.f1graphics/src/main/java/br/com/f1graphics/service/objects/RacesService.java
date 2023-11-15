package br.com.f1graphics.service.objects;

import br.com.f1graphics.dto.response.ListNamesRacesResponseDTO;

public interface RacesService {

    ListNamesRacesResponseDTO getListNamesRaceForSeason(String season);


}
