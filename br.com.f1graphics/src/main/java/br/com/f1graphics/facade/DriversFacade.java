package br.com.f1graphics.facade;

import br.com.f1graphics.dto.request.MRDataDTO;
import br.com.f1graphics.dto.request.MRDataItensDTO;
import br.com.f1graphics.util.RequestUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DriversFacade {

    private final RequestUtil requestUtil;

    public MRDataItensDTO getF1DriversForYears(String years){

        MRDataItensDTO mrDataDTO = requestUtil.get("/"+years+"/drivers.json?limit=150", MRDataItensDTO.class);

        return mrDataDTO;
    }
}
