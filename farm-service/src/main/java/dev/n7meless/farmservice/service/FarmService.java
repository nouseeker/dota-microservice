package dev.n7meless.farmservice.service;

import dev.n7meless.farmservice.dto.Farm;
import dev.n7meless.farmservice.dto.enums.DateEnum;
import dev.n7meless.farmservice.parser.FarmParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FarmService {
    private final FarmParser parser;
    @Value("${parse.dotabuff.url}")
    private String dotabuffUrl;

    public List<Farm> getAllFarm(String date) {
        var uri = UriComponentsBuilder.fromUriString(dotabuffUrl)
                .path("farm")
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
