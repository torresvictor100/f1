package br.com.f1graphics.facade;

import br.com.f1graphics.dto.request.MRDataDTO;
import br.com.f1graphics.util.RequestUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component

public class DriversFacade {

    private RequestUtil requestUtil;

    public MRDataDTO getF1DriversForYears(String years){

        return requestUtil.get("/"+years+"/drivers", MRDataDTO.class);
    }
}
