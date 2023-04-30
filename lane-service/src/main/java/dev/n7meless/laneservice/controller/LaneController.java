package dev.n7meless.laneservice.controller;

import dev.n7meless.laneservice.dto.Lane;
import dev.n7meless.laneservice.service.LaneService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lane")
public class LaneController {
    private final LaneService laneService;

    @GetMapping
    @Operation(description = "Get hero stats on any lane")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful operation",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    examples = @ExampleObject(value = "{\"code\" : 500, \"status\" : \"Internal Server Error!\", \"message\" : \"Internal Server Error!\"}")))})
    public List<Lane> getLanes(@Schema(description = "Lane hero stats. For example, mid or safe lane.",
            example = "mid, safe, off, jungle, roaming")
                               @RequestParam(name = "position", defaultValue = "mid") String position) {
        return laneService.getLaneByPosition(position);
    }
}
