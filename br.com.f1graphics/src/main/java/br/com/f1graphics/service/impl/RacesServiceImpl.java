package br.com.f1graphics.service.impl;

import br.com.f1graphics.dto.response.RaceSprintTableRoundResponseDTO;
import br.com.f1graphics.dto.response.ListNamesRacesResponseDTO;
import br.com.f1graphics.dto.response.RaceTableDriverIdResponseDTO;
import br.com.f1graphics.dto.response.races.RaceResponseDTO;
import br.com.f1graphics.dto.response.racestable.RaceTableResponseDTO;
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

    @Override
    public ListNamesRacesResponseDTO getListNamesRacesForSeason(String season) {

        return getListNamesRacesDTO(raceFacade
                .getMRDataRacePositionItensDTOForSeason(season).getMrData().getRaceTable().getRaces());
    }

    @Override
    public List<RaceResponseDTO> getListRaces(String season) {

        return raceFacade.getMRDataRacePositionItensDTOForSeason(season).getMrData().getRaceTable().getRaces();
    }

    @Override
    public RaceSprintTableRoundResponseDTO getResultSpintRacesForDriverSeason(String season, String drivers) {

        return raceFacade.getResultSpintRacesForDriverSeason(season, drivers).getMrData().getRaceTable();
    }

    @Override
    public RaceSprintTableRoundResponseDTO getRaceSprintTableForRound(String season, String round) {

        return raceFacade.getResultSpintRaces(season, round).getMrData().getRaceTable();
    }

    @Override
    public RaceTableDriverIdResponseDTO getRaceTableForDriverId(String season, String driver) {

        return raceFacade.getDriverResultsForDriverId(season, driver).getMrData().getRaceTable();
    }

    @Override
    public RaceResponseDTO getRaceResultsForRound(String season, int round) {

        return raceFacade.getRaceResultsForRound(season
                , String.valueOf(round)).getMrData().getRaceTable().getRaces().get(0);
    }

    private ListNamesRacesResponseDTO getListNamesRacesDTO(List<RaceResponseDTO> races) {

        List<String> namesRace = new ArrayList<>();

        for (RaceResponseDTO race : races) {
            namesRace.add(race.getRaceName());
        }
        listNamesRaces.setListNamesRacesDTO(namesRace);

        return listNamesRaces;
    }

}
