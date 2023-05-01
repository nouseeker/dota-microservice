package dev.n7meless.impactservice.service;

import dev.n7meless.impactservice.dto.Impact;
import dev.n7meless.impactservice.dto.enums.DateEnum;
import dev.n7meless.impactservice.parser.ImpactParser;
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
public class ImpactService {
    private final ImpactParser parser;
    @Value("${parse.dotabuff.url}")
    private String dotabuffUrl;

    @Cacheable("impact")
    public List<Impact> getAllImpact(String date) {
        var uri = UriComponentsBuilder.fromUriString(dotabuffUrl)
                .path("impact")
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
}
