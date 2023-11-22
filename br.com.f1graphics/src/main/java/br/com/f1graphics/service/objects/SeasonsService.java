package br.com.f1graphics.service.objects;

import br.com.f1graphics.dto.request.ListDriversIdRequestDTO;
import br.com.f1graphics.dto.response.SeaseonResponseDTO;

public interface   SeasonsService {
    SeaseonResponseDTO getSeasonForDriversIds(String season, ListDriversIdRequestDTO listDriversIds);
}
