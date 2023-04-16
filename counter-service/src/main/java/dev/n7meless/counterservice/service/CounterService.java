package dev.n7meless.counterservice.service;

import dev.n7meless.counterservice.dto.Counter;
import dev.n7meless.counterservice.parser.CounterParser;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class CounterService {
    private final CounterParser parser;
    @Value("${parse.dotabuff.uri}")
    private String dotabuffUri;

    @SneakyThrows
    public Counter getCounters(String hero) {
        var uri = UriComponentsBuilder.fromUriString(dotabuffUri)
                .path(hero)
                .path("counters")
                .toUriString();
        Counter counter = parser.parse(uri);
        counter.setDate("month");
        counter.setUpdatedAt(LocalDate.now());
        counter.setLocalizedName(hero);
        return counter;
    }

    @SneakyThrows
    public Counter getCountersByDate(String hero, String date) {
        if (date == null) {
            date = "month";
        }
        var uri = UriComponentsBuilder.fromUriString(dotabuffUri)
                .pathSegment(hero, "counters")
                .queryParam("date", date)
                .toUriString();
        System.out.println(uri);
        Counter counter = parser.parse(uri);
        counter.setDate(date);
        counter.setUpdatedAt(LocalDate.now());
        counter.setLocalizedName(hero);
        return counter;
    }
}
