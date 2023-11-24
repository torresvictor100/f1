package br.com.f1graphics.facade;

import br.com.f1graphics.dto.response.MRDataConstructorStandingsItensResponseDTO;
import br.com.f1graphics.util.RequestUtil;
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
