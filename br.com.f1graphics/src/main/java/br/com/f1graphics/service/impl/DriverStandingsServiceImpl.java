package br.com.f1graphics.service.impl;


import br.com.f1graphics.dto.request.DriverRequestDTO;
import br.com.f1graphics.dto.request.DriverStandingsRequestDTO;
import br.com.f1graphics.dto.request.MRDataDriverStandingsItensRequestDTO;
import br.com.f1graphics.dto.request.StandingsListsRequestDTO;
import br.com.f1graphics.facade.DriverStandingsFacade;
import br.com.f1graphics.service.objects.DriverStandingsService;
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
    public List<StandingsListsRequestDTO> getDriverStandings() {
        return driverStandingsFacade.getDriverStandings().getMRData().getStandingsTable().getStandingsListsRequest();
    }
}
