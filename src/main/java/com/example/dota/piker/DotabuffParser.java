package com.example.dota.piker;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Scope("singleton")
public class DotabuffParser implements Parse {
    Document docWin, docCounter;
    String[] names;
    Float[] winrates, counters, disadvantage;
    List<Float> chance;
    int[] chanceTeam = new int[4];


    public DotabuffParser() {
    }


    public void setConForWinrate(String url) {
        try {
            docWin = Jsoup.connect(url).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setConForCounters(String url) {
        try {
            docCounter = Jsoup.connect(url).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void winrateParse() {
        setConForWinrate("https://www.dotabuff.com/heroes/winning?date=week");
        winrates = new Float[10];
        Element tbody = docWin.select("tbody").first();
        for (int i = 0; i < 10; i++) {
            winrates[i] = Math.round(Float.parseFloat(tbody.getElementsByAttributeValue("href", "/heroes/" + names[i])
                    .first().parent().parent().parent()
                    .child(2)
                    .text().replace("%", "")) * 100) / 100f;
        }
    }


    public void counterParse() {
        counters = new Float[25];
        disadvantage = new Float[25];
        int k = 0;
        for (int i = 0; i < 5; i++) {
            setConForCounters("https://www.dotabuff.com/heroes/" + names[i] + "/counters");
            Element tbody = docCounter.select("tbody").last();
            for (int j = 0; j < 5; j++) {
                Element tb = tbody.getElementsByAttributeValue("href", "/heroes/" + names[j + 5])
                        .first().parent().parent().parent();
                counters[k] = Float.parseFloat(tb
                        .child(3)
                        .text().replace("%", ""));
                disadvantage[k] = -Float.parseFloat(tb
                        .child(2)
                        .text().replace("%", ""));
                k++;
            }
        }
    }

    public void chance() {
        chance = new ArrayList<>(10);

        for (int i = 0; i < 25; i += 5) {
            chance.add(Math.round((counters[i] + counters[i + 1] + counters[i + 2] + counters[i + 3] + counters[i + 4] - 250) * 100) / 100f);
        }
        for (int i = 0; i < 5; i++) {
            chance.add(-(Math.round((counters[i] + counters[i + 5] + counters[i + 10] + counters[i + 15] + counters[i + 20] - 250) * 100) / 100f));
        }
        bestRadiantChance();
        bestDireChance();
        worstRadiantChance();
        worstDireChance();
    }

    public void bestRadiantChance() {
        float max = -100;
        for (int i = 0; i < 5; i++) {
            if (max < chance.get(i)) {
                max = chance.get(i);
            }
        }
        chanceTeam[0] = chance.indexOf(max);
    }

    public void worstRadiantChance() {
        float min = 100;
        for (int i = 0; i < 5; i++) {
            if (min > chance.get(i)) {
                min = chance.get(i);
            }
        }
        chanceTeam[1] = chance.indexOf(min);
    }

    public void bestDireChance() {
        float max = -100;
        for (int i = 5; i < 10; i++) {
            if (max < chance.get(i)) {
                max = chance.get(i);
            }
        }
        chanceTeam[2] = chance.indexOf(max);
    }

    public void worstDireChance() {
        float min = 100;
        for (int i = 5; i < 10; i++) {
            if (min > chance.get(i)) {
                min = chance.get(i);
            }
        }
        chanceTeam[3] = chance.indexOf(min);
    }

    public Float[] getCounters() {
        return counters;
    }

    public Float[] getWinrates() {
        return winrates;
    }

    public Float[] getDisadvantage() {
        return disadvantage;
    }

    public void setNames(String[] names) {
        this.names = names;
    }

    public String[] getNames() {
        return names;
    }

    public List<Float> getChance() {
        return chance;
    }

    public float getTeamChance() {
        return Math.round((chance.get(0) + chance.get(1) + chance.get(2) + chance.get(3) + chance.get(4)) * 100) / 100f;
    }

    public int[] getChanceTeam() {
        return chanceTeam;
    }

}