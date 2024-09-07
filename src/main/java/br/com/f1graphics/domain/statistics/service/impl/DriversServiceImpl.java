package br.com.f1graphics.domain.statistics.service.impl;

import br.com.f1graphics.domain.statistics.dto.response.DriverTableResponseDTO;
import br.com.f1graphics.domain.statistics.dto.response.drive.DriverResponseDTO;
import br.com.f1graphics.domain.statistics.facade.DriversFacade;
import br.com.f1graphics.domain.statistics.service.objects.DriversService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class DriversServiceImpl implements DriversService {

    private final DriversFacade driversFacade;

    @Override
    public DriverTableResponseDTO getDriversForSeason(String season) {

        return driversFacade
                .getDriversForSeason(season).getMrData().getDriverTable();
    }

    @Override
    public DriverResponseDTO getDriverForDriverId(String driverId) {
        return driversFacade.getDriverForDriverId(driverId)
                .getMrData().getDriverTable().getDrivers().get(0);
    }




}
