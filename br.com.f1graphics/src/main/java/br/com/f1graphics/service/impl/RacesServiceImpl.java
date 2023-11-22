package br.com.f1graphics.service.impl;

import br.com.f1graphics.dto.factory.F1GraphicsFactory;
import br.com.f1graphics.dto.request.RaceSprintTableRequestDTO;
import br.com.f1graphics.dto.response.ListNamesRacesResponseDTO;
import br.com.f1graphics.dto.request.RaceRequestDTO;
import br.com.f1graphics.dto.response.RaceResponseDTO;
import br.com.f1graphics.dto.response.RaceSprintTableResponseDTO;
import br.com.f1graphics.dto.response.RaceTableResponseDTO;
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

    private static F1GraphicsFactory factory;

    private ListNamesRacesResponseDTO listNamesRaces = new ListNamesRacesResponseDTO();

    @Override
    public ListNamesRacesResponseDTO getListNamesRacesForSeason(String season) {

        return getListNamesRacesDTO(raceFacade
                .getMRDataRacePositionItensDTOForSeason(season).getMrData().getRaceTable().getRaces());
    }

    @Override
    public RaceSprintTableResponseDTO getResultSpintRacesForDriverSeason(String season, String drivers) {

        return factory.createRaceSprintTableResponseDTO(raceFacade
                .getResultSpintRacesForDriverSeason(season, drivers).getMrData().getRaceTable());
    }

    @Override
    public RaceSprintTableResponseDTO getResultSpintRaces(String season, String round) {

        return factory.createRaceSprintTableResponseDTO(raceFacade
                .getResultSpintRaces(season, round).getMrData().getRaceTable());
    }

    @Override
    public RaceTableResponseDTO getDriverResultsForDriverId(String season, String driver) {

        return factory.createRaceTableResponseDTO(raceFacade.getDriverResultsForDriverId(season, driver)
                .getMrData().getRaceTable());
    }

    @Override
    public RaceResponseDTO getRaceResultsForRound(String season, int round) {

        return factory.createRaceResponseDTO(raceFacade.getRaceResultsForRound(season
                , String.valueOf(round)).getMrData().getRaceTable().getRaces().get(0));
    }

    private ListNamesRacesResponseDTO getListNamesRacesDTO(List<RaceRequestDTO> races) {

        List<String> namesRace = new ArrayList<>();

        for (RaceRequestDTO race : races) {
            namesRace.add(race.getRaceName());
        }
        listNamesRaces.setListNamesRacesDTO(namesRace);

        return listNamesRaces;
    }

}
