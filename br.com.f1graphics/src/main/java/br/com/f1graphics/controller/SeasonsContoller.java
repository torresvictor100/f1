package br.com.f1graphics.controller;

import br.com.f1graphics.dto.request.ListDriversIdRequestDTO;
import br.com.f1graphics.dto.response.ChampionshipResponseDTO;
import br.com.f1graphics.service.objects.SeasonsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping(value = "/f1-graphics/season")
@RestController
@Slf4j
@CrossOrigin(origins = "*")
public class SeasonsContoller {

    private  final SeasonsService seasonsService;

    @GetMapping("/season-drivers-ids/{season}")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(responses = {
            @ApiResponse(description = "get season for driversIds ", responseCode = "200")
    })
    public ResponseEntity<ChampionshipResponseDTO> getSeasonDriversIds(@PathVariable String season,
                                                                          @RequestBody ListDriversIdRequestDTO listDriversId) {
        return ResponseEntity.ok(seasonsService.getSeasonForDriversIds(season, listDriversId));
    }
}
