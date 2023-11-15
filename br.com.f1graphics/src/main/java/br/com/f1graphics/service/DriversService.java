package br.com.f1graphics.service;

import br.com.f1graphics.dto.request.DriverDTO;
import br.com.f1graphics.dto.request.DriverTableDTO;
import br.com.f1graphics.dto.request.MRDataDTO;
import br.com.f1graphics.dto.request.MRDataItensDTO;
import br.com.f1graphics.facade.DriversFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class DriversService {

    private final DriversFacade driversFacade;

    public DriverTableDTO getDriversForYears(String years){
        return driversFacade.getF1DriversForYears(years)
                .getMrData().getDriverTable();
    }

    public DriverDTO getDriverForDriverId(String driverId){
        return driversFacade.getDriverForDriverId(driverId)
                .getMrData().getDriverTable().getDrivers().get(0);
    }

    public DriverDTO getDriversSeason(String driverIdMain,String driverIdComparation){
        return null;
    }

}
