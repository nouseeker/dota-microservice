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
    @Value("${parse.dotabuff.url}")
    private String dotabuffUrl;

    @SneakyThrows
    public Counter getCountersByDate(String hero, String date) {
        var uri = UriComponentsBuilder.fromUriString(dotabuffUrl)
                .pathSegment(hero, "counters")
                .queryParam("date", date)
                .toUriString();
        Counter counter = parser.parse(uri);
        counter.setDate(date);
        counter.setUpdatedAt(LocalDate.now());
        counter.setLocalizedName(hero);
        return counter;
    }
}
