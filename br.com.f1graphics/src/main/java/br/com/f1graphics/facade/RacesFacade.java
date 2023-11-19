package br.com.f1graphics.facade;

import br.com.f1graphics.dto.request.MRDataRacePositionItensRequestDTO;
import br.com.f1graphics.dto.request.MRDataRaceRoundItensDTO;
import br.com.f1graphics.dto.request.MRDataRaceSprintRoundItensDTO;
import br.com.f1graphics.util.RequestUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RacesFacade {

    private final RequestUtil requestUtil;

    public MRDataRacePositionItensRequestDTO getMRDataRacePositionItensDTOForSeason(String season) {

        return requestUtil.get("/" + season + "/results/1.json"
                , MRDataRacePositionItensRequestDTO.class);
    }

    public MRDataRaceSprintRoundItensDTO getResultSpintRacesForDriverSeason(String season, String driversId) {

        return requestUtil.get("/" + season + "/drivers/" + driversId + "/sprint.json"
                , MRDataRaceSprintRoundItensDTO.class);
    }

    public MRDataRaceSprintRoundItensDTO getResultSpintRaces(String season, String round) {

        return requestUtil.get("/" + season + "/" + round + "/sprint.json"
                , MRDataRaceSprintRoundItensDTO.class);
    }

}