package com.example.dota.Piker;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

public class Parse {

    Document docWr;
    Document docUrl;
    int count=0;

    String connect = "https://ru.dotabuff.com/heroes/trends?date=week";
    String url;
    String vals[]=new String[25];
    String winrates[]=new String[25];

    String wr;
    String[] HeroWr = new String[10];
    double resultRadiant;
    double resultDire;
    String counter[][] = new String[6][6];

    public Parse(){
        try {
            docWr = Jsoup.connect(connect).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("conntected");
    }

    public String getWinrate(String name) {
            Elements byName = docWr.getElementsByAttributeValue("data-value", name);
            Element tr = byName.first().parent();
            url = tr.select("a").attr("href").replace("/heroes", "") + "/counters";
            wr = tr.getElementsByTag("td").get(2).text();
            return wr;
            /*int i = 1;
            for (String s: heroes) {
                System.out.println(i+"="+s);
                i++;
            }*/
        //System.out.println(ss);
    }
    public String[] getHeroWr(){
        return HeroWr;
    }
    public String getWrById(int i){
        return winrates[i];
    }
    public String getValsById(int i){
        return vals[i];
    }
    public void parseValue(List<String> radiant,List<String> dire){
        for (int i = 0; i < 5; i++) {
            Elements byName = docWr.getElementsByAttributeValue("data-value", radiant.get(i));
            Element tr = byName.first().parent();
            url = tr.select("a").attr("href") + "/counters";
            try {
                docUrl = Jsoup.connect("https://ru.dotabuff.com" + url).get();
                System.out.println("Connected");
                for (int j = 0; j < 5; j++) {
                    Elements byNameUrl = docUrl.getElementsByAttributeValue("data-value", dire.get(j));
                    Element trUrl = byNameUrl.first().parent();
                    winrates[count] = trUrl.getElementsByTag("td").get(3).text();
                    vals[count++] = trUrl.getElementsByTag("td").get(2).text();

                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
   /* public void parse() {
         String hero;
         String wr;
         String url;
         try {
             doc = Jsoup.connect(connect).get();
             Elements tbody = doc.getElementsByTag("tbody");
             Elements tr_from_tbody = tbody.select("tr");
             byte x = (byte) tr_from_tbody.size();
             for (Element e : tr_from_tbody) {
                 url = e.select("a").attr("href").replace("/heroes", "") + "/counters";
                 hero = e.getElementsByTag("td").get(0).text();
                 wr = e.getElementsByTag("td").get(2).text();
                 heroes.add("Hero:" + hero + " WinRate:" + wr + " URL:" + url +" ");
             }
             Collections.sort(heroes);
             for (String s: heroes) {
                 System.out.println(s);
             }
         } catch (Exception e) {
             e.printStackTrace();
         }

     }*/