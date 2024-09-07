package br.com.f1graphics.domain.statistics.controller;

import br.com.f1graphics.domain.statistics.dto.response.StandingsListsResponseDTO;
import br.com.f1graphics.domain.statistics.service.objects.DriverStandingsService;
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
    public ResponseEntity<List<StandingsListsResponseDTO>> getDriversForSeason() {
        return ResponseEntity.ok(driverStandingsService.getDriverStandings());
    }


}
