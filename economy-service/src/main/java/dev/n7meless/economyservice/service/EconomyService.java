package dev.n7meless.economyservice.service;

import dev.n7meless.economyservice.dto.Economy;
import dev.n7meless.economyservice.enums.DateEnum;
import dev.n7meless.economyservice.exceptions.HeroNotFoundException;
import dev.n7meless.economyservice.parser.EconomyParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.List;

@Slf4j
@Service
@EnableCaching
@RequiredArgsConstructor
public class EconomyService {
    private final EconomyParser parser;
    @Value("${parse.dotabuff.url}")
    private String dotabuffUrl;

    @Cacheable("economy")
    public List<Economy> getAllEconomy(String date) {
        var uri = UriComponentsBuilder.fromUriString(dotabuffUrl)
                .path("economy")
                .queryParam("date", date)
                .toUriString();
        if (DateEnum.fromDate(date)) {
            try {
                return parser.parse(uri);
            } catch (IOException e) {
                log.info("An error occurred while parsing the page with date " + date);
            }
        }
        return null;
    }

    public Economy getEconomyByHeroName(String hero, String date) {
        List<Economy> economies = getAllEconomy(date);
        return economies.stream().filter(economy -> economy.getLocalizedName().equals(hero))
                .findFirst()
                .orElseThrow(() -> new HeroNotFoundException(hero));
    }
}
