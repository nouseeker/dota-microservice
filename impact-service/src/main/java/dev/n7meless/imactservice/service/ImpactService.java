package dev.n7meless.imactservice.service;

import dev.n7meless.imactservice.dto.Impact;
import dev.n7meless.imactservice.dto.enums.DateEnum;
import dev.n7meless.imactservice.parser.ImpactParser;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ImpactService {
    ImpactParser impactParser;

    @SneakyThrows
    public List<Impact> getAllImpact(String date) {
        if (DateEnum.fromDate(date)) {
            return impactParser.parse(date);
        } else return null;
    }
}
