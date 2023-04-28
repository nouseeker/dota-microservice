package dev.n7meless.heroservice.controller;

import dev.n7meless.heroservice.dto.Benchmark;
import dev.n7meless.heroservice.dto.Hero;
import dev.n7meless.heroservice.service.HeroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HeroController {
    private final HeroService heroService;

    @GetMapping("/")
    public ResponseEntity<List<Hero>> getHeroes() {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(heroService.getAllHeroes());
    }

    @GetMapping("/{hero_id}/benchmark")
    public Benchmark getBenchmarks(@PathVariable(name = "hero_id") Long hero_id) {
        return heroService.getBenchmarkByHeroId(hero_id);
    }
}
