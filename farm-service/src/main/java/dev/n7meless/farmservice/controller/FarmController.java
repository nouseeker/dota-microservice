package dev.n7meless.farmservice.controller;

import dev.n7meless.farmservice.dto.Farm;
import dev.n7meless.farmservice.service.FarmService;
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
@RequestMapping("/farm")
public class FarmController {
    private final FarmService farmService;

    public FarmController(FarmService farmService) {
        this.farmService = farmService;
    }

    @GetMapping
    @Operation(description = "Get all farm heroes on any date")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful operation",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    examples = @ExampleObject(value = "{\"code\" : 500, \"status\" : \"Internal Server Error!\", \"message\" : \"Internal Server Error!\"}")))})
    public ResponseEntity<List<Farm>> getAllFarm(@Schema(description = "Period to receive farm all heroes",
            example = "week, month, 3month, 6month,year")
                                                 @RequestParam(defaultValue = "month") String date) {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(farmService.getAllFarm(date));
    }
}
