package br.com.f1graphics.domain.statistics.service.impl;


import br.com.f1graphics.domain.statistics.dto.response.StandingsConstructorListsResponseDTO;
import br.com.f1graphics.domain.statistics.facade.ConstructorStandingsFacade;
import br.com.f1graphics.domain.statistics.service.objects.ConstructorStandingsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
@Slf4j
public class ConstructorStandingsServiceImpl implements ConstructorStandingsService {

    private final ConstructorStandingsFacade constructorStandingsFacade;
    @Override
    public List<StandingsConstructorListsResponseDTO> getConstructorStandings() {
        return constructorStandingsFacade.getConstructorStandings().getMRData().getStandingsTable().getStandingsListsRequest();
    }
}
