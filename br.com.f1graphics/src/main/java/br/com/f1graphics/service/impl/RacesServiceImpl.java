package br.com.f1graphics.service.impl;

import br.com.f1graphics.dto.factory.F1GraphicsFactory;
import br.com.f1graphics.dto.response.ListNamesRacesResponseDTO;
import br.com.f1graphics.dto.request.RaceRequestDTO;
import br.com.f1graphics.facade.RacesFacade;
import br.com.f1graphics.service.objects.RacesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class RacesServiceImpl implements RacesService {

    private final RacesFacade raceFacade;

    private ListNamesRacesResponseDTO listNamesRaces = new ListNamesRacesResponseDTO();

    public ListNamesRacesResponseDTO getListNamesRacesForSeason(String season){

        return getListNamesRacesDTO(raceFacade.getMRDataRacePositionItensDTOForSeason(season).getMrData().getRaceTable().getRaces());
    }

    private ListNamesRacesResponseDTO getListNamesRacesDTO(List<RaceRequestDTO> races){

        List<String> namesRace = new ArrayList<>();

        for (RaceRequestDTO race : races){
            namesRace.add(race.getRaceName());
        }
        listNamesRaces.setListNamesRacesDTO(namesRace);

        return listNamesRaces;
    }
}
