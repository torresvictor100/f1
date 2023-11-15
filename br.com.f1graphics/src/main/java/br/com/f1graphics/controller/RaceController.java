package br.com.f1graphics.controller;

import br.com.f1graphics.dto.request.DriverDTO;
import br.com.f1graphics.dto.request.ListNamesRacingDTO;
import br.com.f1graphics.service.RaceService;
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
public class RaceController {

    private RaceService raceService;

    @GetMapping("/{years}")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(responses = {
            @ApiResponse(description = "get driver for years", responseCode = "200")
    })
    public ResponseEntity<ListNamesRacingDTO> getListNameRaceDTO(@PathVariable String years){

        return ResponseEntity.ok(raceService.getListNamesRaceForYears(years));
    }
}
