package dev.n7meless.farmservice.controller;

import dev.n7meless.farmservice.dto.Farm;
import dev.n7meless.farmservice.service.FarmService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FarmController {
    private final FarmService farmService;

    public FarmController(FarmService farmService) {
        this.farmService = farmService;
    }

    @GetMapping("/")
    @Operation(description = "Get all farm heroes on any date")
    public List<Farm> getAllFarm(@RequestParam String date) {
        return farmService.getAllFarm(date);
    }
}
