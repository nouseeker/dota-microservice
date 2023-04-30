package dev.n7meless.impactservice.controller;

import dev.n7meless.impactservice.dto.Impact;
import dev.n7meless.impactservice.service.ImpactService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/impact")
@RequiredArgsConstructor
public class ImpactController {
    private final ImpactService farmService;

    @GetMapping
    @Operation(description = "Get most game impact heroes on any date")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful operation",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    examples = @ExampleObject(value = "{\"code\" : 500, \"status\" : \"Internal Server Error!\", \"message\" : \"Internal Server Error!\"}")))})
    public ResponseEntity<List<Impact>> getAllFarm(@Schema(description = "Period to receive impact all heroes",
            example = "week, month, 3month, 6month,year")
                                                   @RequestParam(defaultValue = "month") String date) {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(farmService.getAllImpact(date));
    }
}
