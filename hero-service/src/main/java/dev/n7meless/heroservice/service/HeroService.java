package dev.n7meless.heroservice.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.n7meless.heroservice.dto.Benchmark;
import dev.n7meless.heroservice.dto.Hero;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class HeroService {
    ObjectMapper objectMapper;
    RestTemplate restTemplate;
    static String OPENDOTA_API_URL = "https://api.opendota.com/api/";

    @SneakyThrows
    public List<Hero> getAllHeroes() {
        String response = sendRequest(OPENDOTA_API_URL + "heroStats");
        List<Hero> heroes = objectMapper.readValue(response, new TypeReference<List<Hero>>() {
        });
        return heroes;
    }

    @SneakyThrows
    public Benchmark getBenchmarkByHeroId(Long heroId) {
        String response = sendRequest(OPENDOTA_API_URL + "benchmarks?hero_id=" + heroId);
        JSONObject result = new JSONObject(response);
        var newJson = result.get("result").toString();
        Benchmark benchmark = objectMapper.readValue(newJson, Benchmark.class);
        return benchmark;
    }

    private String sendRequest(String url) {
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response.getBody();
    }
}
