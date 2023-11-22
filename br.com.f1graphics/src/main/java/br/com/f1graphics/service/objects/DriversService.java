package br.com.f1graphics.service.objects;

import br.com.f1graphics.dto.response.*;
import br.com.f1graphics.dto.response.drive.DriverResponseDTO;

public interface DriversService {

    DriverTableResponseDTO getDriversForSeason(String season);

    DriverResponseDTO getDriverForDriverId(String driverId);


}
