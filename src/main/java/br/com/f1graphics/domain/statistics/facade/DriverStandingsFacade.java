package br.com.f1graphics.domain.statistics.facade;

import br.com.f1graphics.domain.statistics.dto.response.mrdataitens.MRDataDriverStandingsItensResponseDTO;
import br.com.f1graphics.domain.shared.util.RequestUtil;
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
