package dev.n7meless.counterservice.service;

import dev.n7meless.counterservice.dto.Counter;
import dev.n7meless.counterservice.dto.Matchup;
import dev.n7meless.counterservice.exceptions.EnemyNotFoundException;
import dev.n7meless.counterservice.parser.CounterParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CounterService {
    private final CounterParser parser;
    @Value("${parse.dotabuff.url}")
    private String dotabuffUrl;

    public Counter getCountersByDate(String heroName, String date) {
        try {
            var uri = UriComponentsBuilder.fromUriString(dotabuffUrl)
                    .pathSegment(heroName, "counters")
                    .queryParam("date", date)
                    .toUriString();
            Counter counter = parser.parse(uri);
            counter.setDate(date);
            counter.setUpdatedAt(LocalDate.now());
            counter.setLocalizedName(heroName);
            return counter;
        } catch (IOException e) {
            log.error("Counters with name \"{}\" and date \"{}\" does not exists", heroName, date);
        }
        return null;
    }

    public Counter getCountersVersusEnemy(String heroName, String date, String enemy) {
        Counter counter = getCountersByDate(heroName, date);
        List<Matchup> matchups = counter.getMatchups();
        Matchup matchup = matchups.stream().filter(m -> m.getLocalizedName().equals(enemy))
                .findFirst()
                .orElseThrow(() -> new EnemyNotFoundException(enemy));
        counter.setMatchups(Collections.singletonList(matchup));
        return counter;
    }
}
