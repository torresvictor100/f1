package br.com.f1graphics.facade;

import br.com.f1graphics.dto.response.mrdataitens.MRDataDriverItensResponseDTO;
import br.com.f1graphics.util.RequestUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DriversFacade {

    private final RequestUtil requestUtil;



    public MRDataDriverItensResponseDTO getDriversForSeason(String season) {

        return requestUtil.get("/" + season + "/drivers.json?limit=150"
                , MRDataDriverItensResponseDTO.class);
    }



    public MRDataDriverItensResponseDTO getDriverForDriverId(String driverId) {

        return requestUtil.get("/drivers/" + driverId + ".json?limit=150"
                , MRDataDriverItensResponseDTO.class);
    }
}
