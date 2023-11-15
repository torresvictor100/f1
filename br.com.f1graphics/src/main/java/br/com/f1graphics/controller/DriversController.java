package br.com.f1graphics.controller;

import br.com.f1graphics.dto.request.DriverDTO;
import br.com.f1graphics.dto.request.DriverTableDTO;
import br.com.f1graphics.service.DriversService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping(value = "/drivers")
@RestController
@Slf4j
@CrossOrigin(origins = "*")
public class DriversController {

    private final DriversService driversService;

    @GetMapping("/{season}")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(responses = {
            @ApiResponse(description = "get driver for season", responseCode = "200")
    })
    public ResponseEntity<DriverTableDTO> getDriversForSeason(@PathVariable String season){
        return ResponseEntity.ok(driversService.getDriversForSeason(season));
    }

    @GetMapping("/driver/{driverId}")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(responses = {
            @ApiResponse(description = "get driver for driverId", responseCode = "200")
    })
    public ResponseEntity<DriverDTO> getDriverForDriverId(@PathVariable String driverId){
        return ResponseEntity.ok(driversService.getDriverForDriverId(driverId));
    }



    @GetMapping("/drivers/{driverIdMain}/{driverIdComparation}/{season}")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(responses = {
            @ApiResponse(description = "get driver for season", responseCode = "200")
    })
    public ResponseEntity<DriverDTO> getDriversSeason(@PathVariable String driverIdMain,
                                                          @PathVariable String driverIdComparation,
                                                          @PathVariable String season){
        return ResponseEntity.ok(driversService.getDriversSeason(driverIdMain, driverIdComparation, season));
    }
}