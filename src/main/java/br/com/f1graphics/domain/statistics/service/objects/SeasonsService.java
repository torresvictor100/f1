package br.com.f1graphics.domain.statistics.service.objects;

import br.com.f1graphics.domain.statistics.dto.request.ListDriversIdRequestDTO;
import br.com.f1graphics.domain.statistics.dto.response.SeasonResponseDTO;

public interface   SeasonsService {
    SeasonResponseDTO getSeasonForDriversIds(String season, ListDriversIdRequestDTO listDriversIds);
}
