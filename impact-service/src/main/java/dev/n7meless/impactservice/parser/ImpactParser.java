package dev.n7meless.impactservice.parser;

import dev.n7meless.impactservice.dto.Impact;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Component
public class ImpactParser {

    public List<Impact> parse(String uri) throws IOException {
        var tbody = getTbody(uri);
        List<Impact> impacts = new ArrayList<>();
        for (Element el : tbody.getElementsByTag("tr")) {
            String name = el.getElementsByClass("cell-icon").first().attr("data-value");
            String localizedName = el.getElementsByClass("link-type-hero").first().attr("href");
            Float kda = Float.parseFloat(el.getElementsByTag("td").get(2).attr("data-value"));
            Float kills = Float.parseFloat(el.getElementsByTag("td").get(3).attr("data-value"));
            Float deaths = Float.parseFloat(el.getElementsByTag("td").get(4).attr("data-value"));
            Float assists = Float.parseFloat(el.getElementsByTag("td").get(5).attr("data-value"));
            String matchDuration = el.getElementsByTag("td").get(6).attr("data-value");

            Impact impact = new Impact(name, localizedName, kda, kills, deaths, assists, matchDuration);
            impacts.add(impact);
        }
        return impacts;
    }

    private Element getTbody(String uri) throws IOException {
        Document document = connect(uri);
        return document.select("tbody").first();
    }

    private Document connect(String path) throws IOException {
        java.net.URL url = new URL(path);
        return Jsoup.parse(url, 0);
    }
}