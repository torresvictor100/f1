package br.com.f1graphics.service.objects;

import br.com.f1graphics.dto.request.ListDriversIdRequestDTO;
import br.com.f1graphics.dto.response.ChampionshipResponseDTO;

public interface SeasonService {
    ChampionshipResponseDTO getSeasonDrivers(String season, ListDriversIdRequestDTO listDriversId);
}
