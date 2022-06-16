package com.example.dota.piker;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public enum Parse{
    INSTANCE;
    Document doc;
    String[] counters;
    String[] winrates;
    volatile String connect;
    String name, verylow, low, medium, high, veryhigh = "";

    public void setConnection(String url) {
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("conntected");
    }

/*    public Hero updateWrHeroes() {
        connect = "https://ru.dotabuff.com/heroes/meta";
        setConnection(connect);
        Element tbody = doc.select("tbody").first();
        Element tr = tbody.child(0);
        name = tr.select("td").get(1).text();
        verylow = tr.select("td").get(3).text();
        low = tr.select("td").get(5).text();
        medium = tr.select("td").get(7).text();
        high = tr.select("td").get(9).text();
        veryhigh = tr.select("td").get(11).text();
        return hero.updateHero(name, verylow, low, medium, high, veryhigh);
    }*/

    public void wrParse(String[] id){
        setConnection("https://www.dotabuff.com/heroes/winning");
        winrates = new String[10];
        Element tbody = doc.select("tbody").first();
        for (int i = 0; i < 10; i++) {
           winrates[i]=(tbody.getElementsByAttributeValue("href", "/heroes/" + id[i])
                    .first().parent().parent().parent()
                    .child(2)
                    .text());
        }
    }

    public void counterParse(String[] id){
        counters = new String[25];
        int k =0;
        for (int i = 0; i < 5; i++) {
            setConnection("https://www.dotabuff.com/heroes/" + id[i] + "/counters");
            Element tbody = doc.select("tbody").last();
            for (int j = 0; j < 5; j++) {
                counters[k++]=(tbody.getElementsByAttributeValue("href", "/heroes/" + id[j+5])
                        .first().parent().parent().parent()
                        .child(3)
                        .text());
            }
        }
    }
    public String[] getCounters(){
        return counters;
    }
    public String[] getWinrates(){
        return winrates;
    }

}