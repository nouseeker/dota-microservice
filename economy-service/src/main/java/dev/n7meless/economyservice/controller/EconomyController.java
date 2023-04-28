package dev.n7meless.economyservice.controller;

import dev.n7meless.economyservice.dto.Economy;
import dev.n7meless.economyservice.service.EconomyService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EconomyController {
    private final EconomyService farmService;

    public EconomyController(EconomyService farmService) {
        this.farmService = farmService;
    }


    @GetMapping("/")
    @Operation(description = "Get all economy heroes on any date")
    public List<Economy> getAllEconomy(@RequestParam String date) {
        return farmService.getAllEconomy(date);
    }
}
