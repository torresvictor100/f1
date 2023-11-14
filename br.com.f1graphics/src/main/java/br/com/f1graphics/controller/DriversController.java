package br.com.f1graphics.controller;

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

    @GetMapping("/{years}")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(responses = {
            @ApiResponse(description = "get driver for years", responseCode = "200")
    })
    public ResponseEntity<DriverTableDTO> getDriverForYears(@PathVariable String years){
        return ResponseEntity.ok(driversService.getDriversForYears(years));
    }
}
