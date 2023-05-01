package dev.n7meless.counterservice.parser;

import dev.n7meless.counterservice.dto.Counter;
import dev.n7meless.counterservice.dto.Matchup;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class CounterParser {
    public Counter parse(String url) throws IOException {
        Counter counter = new Counter();
        try {
            var tbody = getTbody(url);
            List<Matchup> matchups = new ArrayList<>();
            for (Element el : tbody.getElementsByTag("tr")) {
                var hero = el.getElementsByTag("td").get(1).getElementsByTag("a");
                String name = hero.text();
                String localizedName = hero.attr("href");
                Float disadvantage = Float.parseFloat(el.getElementsByTag("td").get(2).attr("data-value"));
                Float winRate = Float.parseFloat(el.getElementsByTag("td").get(3).attr("data-value"));
                Long matches = Long.parseLong(el.getElementsByTag("td").get(4).attr("data-value"));

                Matchup matchup = new Matchup(name, localizedName, disadvantage, winRate, matches);

                matchups.add(matchup);
            }
            counter.setMatchups(matchups);
            return counter;
        } catch (NumberFormatException | NullPointerException e) {
            log.info("An error occurred while parsing the page with url " + url);
        }
        return null;
    }

    private Element getTbody(String url) throws IOException {
        Document document = connect(url);
        return document.select("tbody").last();
    }

    private Document connect(String path) throws IOException {
        URL url = new URL(path);
        return Jsoup.parse(url, 0);
    }
}