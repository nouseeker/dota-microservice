package dev.n7meless.heroservice.controller;

import dev.n7meless.heroservice.dto.Benchmark;
import dev.n7meless.heroservice.dto.Hero;
import dev.n7meless.heroservice.model.WebResponse;
import dev.n7meless.heroservice.service.HeroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hero")
public class HeroController {
    private final HeroService heroService;

    @GetMapping
    @Operation(description = "Get hero data")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful operation",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    examples = @ExampleObject(value = "{\"code\" : 500, \"status\" : \"Internal Server Error!\", \"message\" : \"Internal Server Error!\"}")))})
    public ResponseEntity<List<Hero>> getHeroes() {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(heroService.getAllHeroes());
    }

    @GetMapping("/{hero_id}/benchmark")
    @Operation(description = "Benchmarks of average stat values for a hero")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful operation",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = Benchmark.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    examples = @ExampleObject(value = "{\"code\" : 500, \"status\" : \"Internal Server Error!\", \"message\" : \"Internal Server Error!\"}")))})
    public ResponseEntity<?> getBenchmarks(@PathVariable(name = "hero_id")
                                           @Schema(description = "Hero id", example = "1,2,3...125")
                                           Long hero_id) {
        if (hero_id > 124) {
            return ResponseEntity.badRequest().body(WebResponse.builder()
                    .code(HttpStatus.BAD_REQUEST.value())
                    .status(HttpStatus.BAD_REQUEST.getReasonPhrase())
                    .message("Hero id must be between 1 and 125")
                    .build());
        }
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(heroService.getBenchmarkByHeroId(hero_id));
    }
}
