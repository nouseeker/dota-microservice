package dev.n7meless.counterservice.controller;

import dev.n7meless.counterservice.dto.Counter;
import dev.n7meless.counterservice.service.CounterService;
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

@RestController
@RequiredArgsConstructor
@RequestMapping("/counter")
public class CounterController {
    private final CounterService counterService;

    @GetMapping
    @Operation(description = "Get stats of played matches hero versus enemies")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful operation",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = Counter.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    examples = @ExampleObject(value = "{\"code\" : 500, \"status\" : \"Internal Server Error!\", \"message\" : \"Internal Server Error!\"}")))})
    public ResponseEntity<Counter> getCounters(@Schema(description = "Hero name. Cannot be empty.",
            example = "axe, io, anti-mage, magnus")
                                               @RequestParam(value = "hero") String hero,
                                               @Schema(description = "Period to receive counter stats",
                                                       example = "week, month, 3month, 6month,year")
                                               @RequestParam(value = "date",
                                                       defaultValue = "month", required = false) String date) {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(counterService.getCountersByDate(hero, date));
    }

    @GetMapping("/versus")
    @Operation(description = "Get stats of played matches hero versus enemies")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful operation",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = Counter.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    examples = @ExampleObject(value = "{\"code\" : 500, \"status\" : \"Internal Server Error!\", \"message\" : \"Internal Server Error!\"}")))})
    public ResponseEntity<Counter> getCounters(@Schema(description = "Hero name. Cannot be empty.",
            example = "axe, io, anti-mage, magnus")
                                               @RequestParam(value = "hero") String hero,
                                               @Schema(description = "Period to receive counter stats",
                                                       example = "week, month, 3month, 6month,year")
                                               @RequestParam(value = "date",
                                                       defaultValue = "month", required = false) String date,
                                               @Schema(description = "Enemy name",
                                                       example = "axe, io, anti-mage, magnus")
                                               @RequestParam(value = "enemy") String enemy) {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(counterService.getCountersVersusEnemy(hero, date, enemy));
    }
}
