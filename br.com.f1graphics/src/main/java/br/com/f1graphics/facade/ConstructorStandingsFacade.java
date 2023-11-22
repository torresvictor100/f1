package br.com.f1graphics.facade;

import br.com.f1graphics.dto.request.mrdataitens.MRDataConstructorStandingsItensRequestDTO;
import br.com.f1graphics.util.RequestUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ConstructorStandingsFacade {

    private final RequestUtil requestUtil;

    public MRDataConstructorStandingsItensRequestDTO getConstructorStandings(){
        return requestUtil.get("/current/constructorStandings.json"
                , MRDataConstructorStandingsItensRequestDTO.class);
    }

}
