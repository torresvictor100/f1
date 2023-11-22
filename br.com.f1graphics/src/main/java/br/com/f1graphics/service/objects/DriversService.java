package br.com.f1graphics.service.objects;

import br.com.f1graphics.dto.request.ListDriversIdRequestDTO;
import br.com.f1graphics.dto.response.*;

public interface DriversService {

    DriverTableResponseDTO getDriversForSeason(String season);

    DriverResponseDTO getDriverForDriverId(String driverId);


}
