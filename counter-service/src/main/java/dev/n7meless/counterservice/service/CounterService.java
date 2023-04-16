package dev.n7meless.counterservice.service;

import dev.n7meless.economyservice.dto.Economy;
import dev.n7meless.economyservice.dto.enums.DateEnum;
import dev.n7meless.economyservice.parser.EconomyParser;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EconomyService {
    EconomyParser parser;

    @SneakyThrows
    public List<Economy> getAllEconomy(String date) {
        if (DateEnum.fromDate(date)) {
            return parser.parse(date);
        } else return null;
    }
}
