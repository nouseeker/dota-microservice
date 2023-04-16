package dev.n7meless.economyservice.controller;

import dev.n7meless.economyservice.dto.Economy;
import dev.n7meless.economyservice.service.EconomyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/economy")
public class EconomyController {
    private final EconomyService farmService;

    public EconomyController(EconomyService farmService) {
        this.farmService = farmService;
    }


    @GetMapping
    public List<Economy> getAllFarm(@RequestParam String date) {
        return farmService.getAllEconomy(date);
    }
}
