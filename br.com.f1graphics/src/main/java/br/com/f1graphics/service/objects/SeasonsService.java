package br.com.f1graphics.service.objects;

import br.com.f1graphics.dto.request.ListDriversIdRequestDTO;
import br.com.f1graphics.dto.response.SeasonResponseDTO;

public interface   SeasonsService {
    SeasonResponseDTO getSeasonForDriversIds(String season, ListDriversIdRequestDTO listDriversIds);
}
