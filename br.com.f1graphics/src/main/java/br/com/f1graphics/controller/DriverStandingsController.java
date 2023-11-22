package br.com.f1graphics.controller;

import br.com.f1graphics.dto.request.StandingsListsRequestDTO;
import br.com.f1graphics.service.objects.DriverStandingsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping(value = "/f1-graphics/driverstandings")
@RestController
@Slf4j
@CrossOrigin(origins = "*")
public class DriverStandingsController {

    private final DriverStandingsService driverStandingsService;

    @GetMapping("/")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(responses = {
            @ApiResponse(description = "get drivers for season", responseCode = "200")
    })
    public ResponseEntity<List<StandingsListsRequestDTO>> getDriversForSeason() {
        return ResponseEntity.ok(driverStandingsService.getDriverStandings());
    }


}
