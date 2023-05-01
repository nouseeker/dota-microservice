package dev.n7meless.economyservice.controller;

import dev.n7meless.economyservice.dto.Economy;
import dev.n7meless.economyservice.service.EconomyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/economy")
public class EconomyController {
    private final EconomyService farmService;

    public EconomyController(EconomyService farmService) {
        this.farmService = farmService;
    }


    @GetMapping
    @Operation(description = "Get all economy heroes on any date")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful operation",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    examples = @ExampleObject(value = "{\"code\" : 500, \"status\" : \"Internal Server Error!\", \"message\" : \"Internal Server Error!\"}")))})
    public ResponseEntity<List<Economy>> getAllEconomy(@Schema(description = "Period to receive economy all heroes",
            example = "week, month, 3month, 6month,year")
                                                       @RequestParam(name = "date",
                                                               defaultValue = "month") String date) {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(farmService.getAllEconomy(date));
    }

    @GetMapping("/hero")
    @Operation(description = "Get economy by hero name on any date")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful operation",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Economy.class))),
            @ApiResponse(responseCode = "400", description = "Bad request!", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    examples = @ExampleObject(value = "{\"code\" : 400, \"status\" : \"Bad request!\", \"message\" : \"Hero does not exists!\"}")))})
    public ResponseEntity<Economy> getEconomyByHeroName(@Schema(description = "Hero name in lower case",
            example = "axe, io, magnus, clockwerk")
                                                        @RequestParam(name = "name") String name,
                                                        @Schema(description = "Period to receive economy all heroes",
                                                                example = "week, month, 3month, 6month,year")
                                                        @RequestParam(name = "date",
                                                                defaultValue = "month") String date) {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(farmService.getEconomyByHeroName(name, date));
    }
}
