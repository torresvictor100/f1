package br.com.f1graphics.domain.statistics.facade;

import br.com.f1graphics.domain.statistics.dto.response.mrdataitens.MRDataConstructorStandingsItensResponseDTO;
import br.com.f1graphics.domain.shared.util.RequestUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ConstructorStandingsFacade {

    private final RequestUtil requestUtil;

    public MRDataConstructorStandingsItensResponseDTO getConstructorStandings(){
        return requestUtil.get("/current/constructorStandings.json"
                , MRDataConstructorStandingsItensResponseDTO.class);
    }

}
