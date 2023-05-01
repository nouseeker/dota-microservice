package dev.n7meless.laneservice.parser;

import dev.n7meless.laneservice.dto.Lane;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Component
public class LaneParser {

    public List<Lane> parse(String uri, String position) throws IOException {
        var tbody = getTbody(uri);
        List<Lane> lanes = new ArrayList<>();
        for (Element el : tbody.getElementsByTag("tr")) {
            String name = el.getElementsByClass("cell-icon").first().attr("data-value");
            String localizedName = el.getElementsByClass("link-type-hero").first().attr("href");
            Float presence = Float.parseFloat(el.getElementsByTag("td").get(2).attr("data-value"));
            Float winRate = Float.parseFloat(el.getElementsByTag("td").get(3).attr("data-value"));
            Float kda = Float.parseFloat(el.getElementsByTag("td").get(4).attr("data-value"));
            Integer gpm = Integer.parseInt(el.getElementsByTag("td").get(5).text());
            Integer xpm = Integer.parseInt(el.getElementsByTag("td").get(6).text());

            var lane = Lane.builder()
                    .localizedName(localizedName)
                    .name(name)
                    .presence(presence)
                    .winRate(winRate)
                    .kda(kda).gpm(gpm).xpm(xpm)
                    .position(position)
                    .build();

            lanes.add(lane);
        }
        return lanes;
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
