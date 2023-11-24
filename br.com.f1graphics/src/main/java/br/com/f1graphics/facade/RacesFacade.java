package br.com.f1graphics.facade;

import br.com.f1graphics.dto.response.MRDataRaceDriverIdItensResponseDTO;
import br.com.f1graphics.dto.response.MRDataRacePositionItensResponseDTO;
import br.com.f1graphics.dto.response.mrdataitens.MRDataRaceRoundItensDTO;
import br.com.f1graphics.dto.response.MRDataRaceSprintRoundItensResponseDTO;
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

    public MRDataRaceSprintRoundItensResponseDTO getResultSpintRacesForDriverSeason(String season, String driversId) {

        return requestUtil.get("/" + season + "/drivers/" + driversId + "/sprint.json"
                , MRDataRaceSprintRoundItensResponseDTO.class);
    }

    public MRDataRaceSprintRoundItensResponseDTO getResultSpintRaces(String season, String round) {

        return requestUtil.get("/" + season + "/" + round + "/sprint.json"
                , MRDataRaceSprintRoundItensResponseDTO.class);
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
