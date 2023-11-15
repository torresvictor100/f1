package br.com.f1graphics.facade;

import br.com.f1graphics.dto.request.MRDataDriverItensDTO;
import br.com.f1graphics.dto.request.MRDataRacePositionItensDTO;
import br.com.f1graphics.util.RequestUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RaceFacade {

    private final RequestUtil requestUtil;

    public MRDataRacePositionItensDTO getListNamesRaceForSeason(String season){

        return requestUtil.get("/"+season+"/results/1.json"
                , MRDataRacePositionItensDTO.class);
    }

}
