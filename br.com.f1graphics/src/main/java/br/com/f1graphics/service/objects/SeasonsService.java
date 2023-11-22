package br.com.f1graphics.service.objects;

import br.com.f1graphics.dto.request.ListDriversIdRequestDTO;
import br.com.f1graphics.dto.response.ChampionshipResponseDTO;

public interface   SeasonsService {
    ChampionshipResponseDTO getSeasonForDriversIds(String season, ListDriversIdRequestDTO listDriversIds);
}
