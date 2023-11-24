package br.com.f1graphics.facade;

import br.com.f1graphics.dto.request.mrdataitens.MRDataDriverItensRequestDTO;
import br.com.f1graphics.util.RequestUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DriversFacade {

    private final RequestUtil requestUtil;



    public MRDataDriverItensRequestDTO getDriversForSeason(String season) {

        return requestUtil.get("/" + season + "/drivers.json?limit=150"
                , MRDataDriverItensRequestDTO.class);
    }



    public MRDataDriverItensRequestDTO getDriverForDriverId(String driverId) {

        return requestUtil.get("/drivers/" + driverId + ".json?limit=150"
                , MRDataDriverItensRequestDTO.class);
    }
}
