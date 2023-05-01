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

    public List<Farm> parse(String uri) throws IOException {
        var tbody = getTbody(uri);
        List<Farm> farms = new ArrayList<>();
        for (Element el : tbody.getElementsByTag("tr")) {
            String name = el.getElementsByClass("cell-icon").first().attr("data-value");
            String localizedName = el.getElementsByClass("link-type-hero").first().attr("href");
            Float lastHits = Float.parseFloat(el.getElementsByTag("td").get(2).attr("data-value"));
            Float denies = Float.parseFloat(el.getElementsByTag("td").get(3).attr("data-value"));

            Farm farm = new Farm(name, localizedName, lastHits, denies);
            farms.add(farm);
        }
        return farms;
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