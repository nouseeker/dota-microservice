package dev.n7meless.farmservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest(classes = FarmServiceApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = {
        "spring.cloud.discovery.enabled=false",
        "spring.cloud.config.discovery.enabled=false",
        "parse.dotabuff.url=https://www.dotabuff.com/heroes/"})
public class FarmServiceApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void shouldReturn200WhenGetAllFarm() {
        ResponseEntity<List> entity = this.testRestTemplate.getForEntity(
                "http://localhost:" + this.port + "/farm?date=year", List.class);

        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}

