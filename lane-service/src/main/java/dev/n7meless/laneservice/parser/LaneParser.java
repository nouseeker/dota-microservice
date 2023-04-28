package dev.n7meless.laneservice.parser;

import dev.n7meless.laneservice.dto.Lane;
import dev.n7meless.laneservice.dto.enums.LaneEnum;
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
    private static final String URL = "https://www.dotabuff.com/heroes/lanes";

    public List<Lane> parse(String lanePath) throws IOException {
        var URL = urlBuilder(lanePath);
        Document document = connect(URL);
        Element element = document.select("tbody").first();
        List<Lane> lanes = new ArrayList<>();
        for (Element el : element.getElementsByTag("tr")) {
            String name = el.getElementsByClass("cell-icon").first().attr("data-value");
            String imageName = el.getElementsByClass("link-type-hero").first().attr("href");
            Float presence = Float.parseFloat(el.getElementsByTag("td").get(2).attr("data-value"));
            Float winRate = Float.parseFloat(el.getElementsByTag("td").get(3).attr("data-value"));
            Float kda = Float.parseFloat(el.getElementsByTag("td").get(4).attr("data-value"));
            Integer gpm = Integer.parseInt(el.getElementsByTag("td").get(5).text());
            Integer xpm = Integer.parseInt(el.getElementsByTag("td").get(6).text());

            var lane = Lane.builder()
                    .imageName(imageName)
                    .name(name)
                    .presence(presence)
                    .winRate(winRate)
                    .kda(kda).gpm(gpm).xpm(xpm)
                    .lane(LaneEnum.fromLane(lanePath))
                    .build();

            lanes.add(lane);
        }
        return lanes;
    }

    private Document connect(String currentUrl) throws IOException {
        URL url = new URL(currentUrl);
        return Jsoup.parse(url, 0);
    }

    private String urlBuilder(String param) {
        StringBuilder sb = new StringBuilder();
        sb.append(URL);
        sb.append("?lane=");
        sb.append(param);
        return sb.toString();
    }
}
