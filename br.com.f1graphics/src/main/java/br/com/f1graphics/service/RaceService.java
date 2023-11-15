package br.com.f1graphics.service;

import br.com.f1graphics.dto.request.ListNamesRacingDTO;
import br.com.f1graphics.dto.request.RaceDTO;
import br.com.f1graphics.facade.RaceFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class RaceService {

    private final RaceFacade raceFacade;


    private ListNamesRacingDTO listNamesRacingDTO = new ListNamesRacingDTO();

    public ListNamesRacingDTO getListNamesRaceForSeason(String season){

        return getListNamesRacingDTO(raceFacade.getMRDataRacePositionItensDTOForSeason(season).getMrData().getRaceTable().getRaces());
    }

    private ListNamesRacingDTO getListNamesRacingDTO(List<RaceDTO> races){

        List<String> namesRace = new ArrayList<>();

        for (RaceDTO race : races){
            namesRace.add(race.getRaceName());
        }
        listNamesRacingDTO.setListNamesRacingDTO(namesRace);

        return listNamesRacingDTO;
    }
}
