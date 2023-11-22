package br.com.f1graphics.service.impl;


import br.com.f1graphics.dto.request.StandingsConstructorListsRequestDTO;
import br.com.f1graphics.dto.request.StandingsListsRequestDTO;
import br.com.f1graphics.facade.ConstructorStandingsFacade;
import br.com.f1graphics.facade.DriverStandingsFacade;
import br.com.f1graphics.service.objects.ConstructorStandingsService;
import br.com.f1graphics.service.objects.DriverStandingsService;
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
    public List<StandingsConstructorListsRequestDTO> getConstructorStandings() {
        return constructorStandingsFacade.getConstructorStandings().getMRData().getStandingsTable().getStandingsListsRequest();
    }
}
