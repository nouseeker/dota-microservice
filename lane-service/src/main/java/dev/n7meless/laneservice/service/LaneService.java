package dev.n7meless.laneservice.service;

import dev.n7meless.laneservice.dto.Lane;
import dev.n7meless.laneservice.parser.LaneParser;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableCaching
@RequiredArgsConstructor
public class LaneService {
    private final LaneParser parser;

    @SneakyThrows
    @Cacheable("lanes")
    public List<Lane> getLanesByLane(String lane) {
        return parser.parse(lane);
    }

    @CacheEvict(value = "lanes", allEntries = true)
    @Scheduled(fixedRateString = "${caching.spring.lanesTTL}")
    public void emptyHotelsCache() {
        System.out.println("clean");
    }
}
