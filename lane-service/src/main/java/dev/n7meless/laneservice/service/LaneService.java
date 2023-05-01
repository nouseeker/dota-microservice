package dev.n7meless.laneservice.service;

import dev.n7meless.laneservice.dto.Lane;
import dev.n7meless.laneservice.dto.enums.LaneEnum;
import dev.n7meless.laneservice.parser.LaneParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
@EnableCaching
@RequiredArgsConstructor
public class LaneService {
    private final LaneParser parser;
    @Value("${parse.dotabuff.url}")
    private String dotabuffUrl;

    @Cacheable("lanes")
    public List<Lane> getLaneByPosition(String position) {
        var uri = UriComponentsBuilder.fromUriString(dotabuffUrl)
                .path("lanes")
                .queryParam("lane", position)
                .toUriString();
        if (LaneEnum.fromLane(position)) {
            try {
                return parser.parse(uri, position);
            } catch (IOException e) {
                log.info("An error occurred while parsing the page with position lane " + position);
            }
        }
        return null;
    }

    @CacheEvict(value = "lanes", allEntries = true)
    @Scheduled(fixedRateString = "${caching.spring.lanesTTL}")
    public void emptyLanesCache() {
        log.info("the cache \"lanes\" has been cleared");
    }
}
