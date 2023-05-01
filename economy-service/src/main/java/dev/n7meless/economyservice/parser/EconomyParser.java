package dev.n7meless.economyservice.parser;

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

    public List<Economy> parse(String uri) throws IOException {
        var tbody = getTbody(uri);
        List<Economy> economies = new ArrayList<>();
        for (Element el : tbody.getElementsByTag("tr")) {
            String name = el.getElementsByClass("cell-icon").first().attr("data-value");
            String localizedName = el.getElementsByClass("link-type-hero").first().attr("href");
            Float gold = Float.parseFloat(el.getElementsByTag("td").get(2).attr("data-value"));
            Float experience = Float.parseFloat(el.getElementsByTag("td").get(3).attr("data-value"));

            Economy economy = new Economy(name, localizedName, gold, experience);

            economies.add(economy);
        }
        return economies;
    }

    public Element getTbody(String url) throws IOException {
        Document document = connect(url);
        return document.select("tbody").first();
    }

    private Document connect(String path) throws IOException {
        java.net.URL url = new URL(path);
        return Jsoup.parse(url, 0);
    }
}