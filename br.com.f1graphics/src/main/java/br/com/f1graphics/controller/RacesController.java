package br.com.f1graphics.controller;

import br.com.f1graphics.dto.response.ListNamesRacesResponseDTO;
import br.com.f1graphics.service.objects.RacesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping(value = "/races")
@RestController
@Slf4j
@CrossOrigin(origins = "*")
public class RacesController {

    private final RacesService racesService;

    @GetMapping("/{season}")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(responses = {
            @ApiResponse(description = "get driver for season", responseCode = "200")
    })
    public ResponseEntity<ListNamesRacesResponseDTO> getListNameRacesDTO(@PathVariable String season){

        return ResponseEntity.ok(racesService.getListNamesRacesForSeason(season));
    }
}
