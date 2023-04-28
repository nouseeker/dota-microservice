package dev.n7meless.counterservice.controller;

import dev.n7meless.counterservice.dto.Counter;
import dev.n7meless.counterservice.service.CounterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CounterController {
    private final CounterService counterService;

    @GetMapping("/{hero}")
    public ResponseEntity<Counter> getCounters(@PathVariable(value = "hero") String hero,
                                               @RequestParam(value = "date",
                                                       defaultValue = "month", required = false) String date) {
        System.out.println(date);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(counterService.getCountersByDate(hero, date));
    }
}
