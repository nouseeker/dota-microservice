package com.example.dota.controllers;

import com.example.dota.model.History;
import com.example.dota.piker.HeroList;
import com.example.dota.piker.Parse;
import com.example.dota.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class MainController {
    @Autowired
    private HistoryService historyService;

    @GetMapping("/counterpick")
    public String greeting(Model model) {
        model.addAttribute("heroes", new HeroList().getAllNameHeroes());
        return "counterpick";
    }

    @PostMapping("/selectHero")
    public String heroController(@RequestParam(value = "heroes", required = false) String[] id
                                 /*@RequestParam(value = "defCh", required = false) int def,
                                 @RequestParam(value = "rankCh", required = false) int rank,
                                 @RequestParam(value = "roleCh", required = false) int role,
                                 @RequestParam(value = "date", required = false) int date*/) {

        historyService.saveHistory(new History(id[0],
                id[1],id[2],id[3],id[4],id[5],id[6],id[7],id[8],id[9]))
        System.out.println("Основной поток");
        /*Thread second = new Thread(new Runnable() {
            @Override
            public void run() {
                Parse.INSTANCE.counterParse(heroesID);
            }
        });
        second.start();*/

        Parse.INSTANCE.wrParse(heroesID);
        Parse.INSTANCE.counterParse(heroesID);
        return "statistic";
    }
  @GetMapping("/statistic")
    public String stats(Model model){
      model.addAttribute("heroes",heroesID);
      model.addAttribute("winrates",Parse.INSTANCE.getWinrates());
      model.addAttribute("counters",Parse.INSTANCE.getCounters());
        return "statistic";
    }


}