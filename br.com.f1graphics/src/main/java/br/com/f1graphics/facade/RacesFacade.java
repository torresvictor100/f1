package br.com.f1graphics.facade;

import br.com.f1graphics.dto.response.MRDataRaceDriverIdItensResponseDTO;
import br.com.f1graphics.dto.response.MRDataRacePositionItensResponseDTO;
import br.com.f1graphics.dto.request.mrdataitens.MRDataRaceRoundItensDTO;
import br.com.f1graphics.dto.request.mrdataitens.MRDataRaceSprintRoundItensDTO;
import br.com.f1graphics.util.RequestUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RacesFacade {

    private final RequestUtil requestUtil;

    public MRDataRacePositionItensResponseDTO getMRDataRacePositionItensDTOForSeason(String season) {

        return requestUtil.get("/" + season + "/results/1.json"
                , MRDataRacePositionItensResponseDTO.class);
    }

    public MRDataRaceSprintRoundItensDTO getResultSpintRacesForDriverSeason(String season, String driversId) {

        return requestUtil.get("/" + season + "/drivers/" + driversId + "/sprint.json"
                , MRDataRaceSprintRoundItensDTO.class);
    }

    public MRDataRaceSprintRoundItensDTO getResultSpintRaces(String season, String round) {

        return requestUtil.get("/" + season + "/" + round + "/sprint.json"
                , MRDataRaceSprintRoundItensDTO.class);
    }

    public MRDataRaceRoundItensDTO getRaceResultsForRound(String season, String round) {

        return requestUtil.get("/" + season + "/" + round + "/results.json"
                , MRDataRaceRoundItensDTO.class);
    }

    public MRDataRaceDriverIdItensResponseDTO getDriverResultsForDriverId(String season, String driverId) {

        MRDataRaceDriverIdItensResponseDTO mrRDataRaceDriverIdItensRequestDTO = requestUtil.get("/" + season + "/drivers/" + driverId + "/results.json"
                , MRDataRaceDriverIdItensResponseDTO.class);

        return mrRDataRaceDriverIdItensRequestDTO;
    }

}
