package br.com.f1graphics.service.objects;

import br.com.f1graphics.dto.response.ListNamesRacingDTO;

public interface RacesService {

    ListNamesRacingDTO getListNamesRaceForSeason(String season);


}
