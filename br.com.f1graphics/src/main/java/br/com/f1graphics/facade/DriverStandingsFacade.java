package br.com.f1graphics.facade;

import br.com.f1graphics.dto.response.MRDataDriverStandingsItensResponseDTO;
import br.com.f1graphics.util.RequestUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DriverStandingsFacade {

    private final RequestUtil requestUtil;

    public MRDataDriverStandingsItensResponseDTO getDriverStandings(){
        return requestUtil.get("/current/driverStandings.json"
                , MRDataDriverStandingsItensResponseDTO.class);
    }

}
