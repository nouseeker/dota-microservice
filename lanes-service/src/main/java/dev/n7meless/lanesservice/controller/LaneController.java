package dev.n7meless.lanesservice.controller;

import dev.n7meless.lanesservice.dto.Lane;
import dev.n7meless.lanesservice.service.LaneService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/lane")
@RequiredArgsConstructor
public class LaneController {
    private final LaneService laneService;

    @GetMapping
    public List<Lane> getLanes(@RequestParam(name = "lane") String lane) {
        return laneService.getLanesByLane(lane);
    }
}
