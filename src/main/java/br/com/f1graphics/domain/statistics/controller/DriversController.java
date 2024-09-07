package br.com.f1graphics.domain.statistics.controller;

import br.com.f1graphics.domain.statistics.dto.response.drive.DriverResponseDTO;
import br.com.f1graphics.domain.statistics.dto.response.DriverTableResponseDTO;
import br.com.f1graphics.domain.statistics.service.objects.DriversService;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping(value = "/f1-graphics/drivers")
@RestController
@Slf4j
@CrossOrigin(origins = "*")
public class DriversController {

    private final DriversService driversService;

    @GetMapping("/drivers-season/{season}")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(responses = {
            @ApiResponse(description = "get drivers for season", responseCode = "200")
    })
    public ResponseEntity<DriverTableResponseDTO> getDriversForSeason(@PathVariable String season) {
        return ResponseEntity.ok(driversService.getDriversForSeason(season));
    }

    @GetMapping("/driver/{driverId}")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(responses = {
            @ApiResponse(description = "get driver for driverId", responseCode = "200")
    })
    public ResponseEntity<DriverResponseDTO> getDriverForDriverId(@PathVariable String driverId) {
        return ResponseEntity.ok(driversService.getDriverForDriverId(driverId));
    }

}
