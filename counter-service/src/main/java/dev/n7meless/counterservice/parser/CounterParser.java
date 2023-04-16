package dev.n7meless.counterservice.parser;

import dev.n7meless.counterservice.dto.Counter;
import dev.n7meless.counterservice.dto.Matchup;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Component
public class CounterParser {
    public Counter parse(String url) throws IOException {
        var tbody = getTbody(url);
        List<Matchup> matchups = new ArrayList<>();
        for (Element el : tbody.getElementsByTag("tr")) {
            var hero = el.getElementsByTag("td").get(1).getElementsByTag("a");
            String name = hero.text();
            String localizedName = hero.attr("href");
            Float disadvantage = Float.parseFloat(el.getElementsByTag("td").get(2).attr("data-value"));
            Float winRate = Float.parseFloat(el.getElementsByTag("td").get(3).attr("data-value"));
            Long matches = Long.parseLong(el.getElementsByTag("td").get(4).attr("data-value"));

            var matchup = Matchup.builder()
                    .name(name)
                    .localizedName(localizedName)
                    .disadvantage(disadvantage)
                    .winRate(winRate)
                    .matches(matches)
                    .build();

            matchups.add(matchup);
        }
        return Counter.builder().matchups(matchups).build();
    }

    private Element getTbody(String url) throws IOException {
        Document document = connect(url);
        return document.select("tbody").last();
    }

    private Document connect(String path) throws IOException {
        java.net.URL url = new URL(path);
        return Jsoup.parse(url, 0);
    }

}