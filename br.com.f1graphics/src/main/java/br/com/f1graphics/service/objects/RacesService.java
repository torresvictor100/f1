package br.com.f1graphics.service.objects;

import br.com.f1graphics.dto.request.ListNamesRacingDTO;

public interface RacesService {

    ListNamesRacingDTO getListNamesRaceForSeason(String season);


}
