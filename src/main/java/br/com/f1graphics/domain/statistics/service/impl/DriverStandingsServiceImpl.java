package br.com.f1graphics.domain.statistics.service.impl;


import br.com.f1graphics.domain.statistics.dto.response.StandingsListsResponseDTO;
import br.com.f1graphics.domain.statistics.facade.DriverStandingsFacade;
import br.com.f1graphics.domain.statistics.service.objects.DriverStandingsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
@Slf4j
public class DriverStandingsServiceImpl implements DriverStandingsService {

    private final DriverStandingsFacade driverStandingsFacade;

    @Override
    public List<StandingsListsResponseDTO> getDriverStandings() {
        return driverStandingsFacade.getDriverStandings().getMRData().getStandingsTable().getStandingsListsRequest();
    }
}
