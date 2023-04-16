package dev.n7meless.counterservice.controller;

import dev.n7meless.counterservice.dto.Counter;
import dev.n7meless.counterservice.service.CounterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/counters")
@RequiredArgsConstructor
public class CounterController {
    private final CounterService counterService;

    @RequestMapping(method = RequestMethod.GET)
    public Counter getCounters(@RequestParam(value = "hero") String hero,
                               @RequestParam(value = "date",
                                       defaultValue = "month", required = false) String date) {
        System.out.println(date);
        return counterService.getCountersByDate(hero, date);
    }
}
