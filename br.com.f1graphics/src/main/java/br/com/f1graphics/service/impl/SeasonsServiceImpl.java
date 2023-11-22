package br.com.f1graphics.service.impl;

import br.com.f1graphics.dto.request.ListDriversIdRequestDTO;
import br.com.f1graphics.dto.response.ChampionshipResponseDTO;
import br.com.f1graphics.service.objects.SeasonsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class SeasonsServiceImpl implements SeasonsService {
    @Override
    public ChampionshipResponseDTO getSeasonForDriversIds(String season, ListDriversIdRequestDTO listDriversIds) {
        return null;
    }
}
