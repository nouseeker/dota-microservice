package dev.n7meless.farmservice.service;

import dev.n7meless.farmservice.dto.Farm;
import dev.n7meless.farmservice.dto.enums.DateEnum;
import dev.n7meless.farmservice.parser.FarmParser;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FarmService {
    FarmParser parser;

    @SneakyThrows
    public List<Farm> getAllFarm(String date) {
        if (DateEnum.fromDate(date)) {
            return parser.parse(date);
        } else return null;
    }
}
