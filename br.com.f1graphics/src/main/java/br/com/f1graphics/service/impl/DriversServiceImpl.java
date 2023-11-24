package br.com.f1graphics.service.impl;

import br.com.f1graphics.dto.factory.F1GraphicsFactory;
import br.com.f1graphics.dto.response.*;
import br.com.f1graphics.dto.response.drive.DriverResponseDTO;
import br.com.f1graphics.facade.DriversFacade;
import br.com.f1graphics.service.objects.DriversService;
import br.com.f1graphics.service.objects.RacesService;
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
