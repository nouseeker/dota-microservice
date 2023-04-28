package dev.n7meless.laneservice.controller;

import dev.n7meless.laneservice.dto.Lane;
import dev.n7meless.laneservice.service.LaneService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LaneController {
    private final LaneService laneService;

    @GetMapping("/")
    @Operation(description = "Get hero stats on any lane")
    public List<Lane> getLanes(@RequestParam(name = "lane") String lane) {
        return laneService.getLanesByLane(lane);
    }
}
