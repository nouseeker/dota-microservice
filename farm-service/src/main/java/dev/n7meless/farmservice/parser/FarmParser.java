package dev.n7meless.farmservice.parser;

import dev.n7meless.farmservice.dto.Farm;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Component
public class FarmParser {
    private static final String URL = "https://www.dotabuff.com/heroes/farm";

    public List<Farm> parse(String param) throws IOException {
        var tbody = getTbody(param);
        List<Farm> lanes = new ArrayList<>();
        for (Element el : tbody.getElementsByTag("tr")) {
            String name = el.getElementsByClass("cell-icon").first().attr("data-value");
            String imageName = el.getElementsByClass("link-type-hero").first().attr("href");
            Float lastHits = Float.parseFloat(el.getElementsByTag("td").get(2).attr("data-value"));
            Float denies = Float.parseFloat(el.getElementsByTag("td").get(3).attr("data-value"));

            var lane = Farm.builder()
                    .imageName(imageName)
                    .name(name)
                    .lastHits(lastHits)
                    .denies(denies)
                    .build();

            lanes.add(lane);
        }
        return lanes;
    }

    public Element getTbody(String param) throws IOException {
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