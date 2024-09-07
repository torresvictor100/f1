package br.com.f1graphics.domain.statistics.service.objects;

import br.com.f1graphics.domain.statistics.dto.response.DriverTableResponseDTO;
import br.com.f1graphics.domain.statistics.dto.response.drive.DriverResponseDTO;

public interface DriversService {

    DriverTableResponseDTO getDriversForSeason(String season);

    DriverResponseDTO getDriverForDriverId(String driverId);


}
