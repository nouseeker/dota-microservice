package dev.n7meless.counterservice.parser;

import dev.n7meless.economyservice.dto.Economy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Component
public class EconomyParser {
    private static final String URL = "https://www.dotabuff.com/heroes/economy";

    public List<Economy> parse(String param) throws IOException {
        var tbody = getTbody(param);
        List<Economy> lanes = new ArrayList<>();
        for (Element el : tbody.getElementsByTag("tr")) {
            String name = el.getElementsByClass("cell-icon").first().attr("data-value");
            String imageName = el.getElementsByClass("link-type-hero").first().attr("href");
            Float gold = Float.parseFloat(el.getElementsByTag("td").get(2).attr("data-value"));
            Float experience = Float.parseFloat(el.getElementsByTag("td").get(3).attr("data-value"));

            var lane = Economy.builder()
                    .imageName(imageName)
                    .name(name)
                    .gold(gold)
                    .experience(experience)
                    .build();

            lanes.add(lane);
        }
        return lanes;
    }

    public Element getTbody(String param) throws IOException{
        var path = urlBuilder(param);
        Document document = connect(path);
        return document.select("tbody").first();
    }

    private Document connect(String path) throws IOException {
        java.net.URL url = new URL(path);
        return Jsoup.parse(url, 0);
    }

    private String urlBuilder(String param) {
        StringBuilder sb = new StringBuilder();
        sb.append(URL);
        sb.append("?date=");
        sb.append(param);
        return sb.toString();
    }
}