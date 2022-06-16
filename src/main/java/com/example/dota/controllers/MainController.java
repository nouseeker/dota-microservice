package com.example.dota.controllers;

import com.example.dota.piker.HeroList;
import com.example.dota.piker.Parse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {

    String[] names;

    @GetMapping("/counterpick")
    public String greeting(Model model) {
        model.addAttribute("heroes", new HeroList().getAllNameHeroes());
        return "counterpick";
    }

    @PostMapping("/selectHero")
    public String heroController(@RequestParam(value = "heroes", required = false) String[] names
                                 /*@RequestParam(value = "defCh", required = false) int def,
                                 @RequestParam(value = "rankCh", required = false) int rank,
                                 @RequestParam(value = "roleCh", required = false) int role,
                                 @RequestParam(value = "date", required = false) int date*/) {
        this.names = names;
        System.out.println("Основной поток");
        /*Thread second = new Thread(new Runnable() {
            @Override
            public void run() {
                Parse.INSTANCE.counterParse(heroesID);
            }
        });
        second.start();*/
        Parse.INSTANCE.wrParse(names);
        Parse.INSTANCE.counterParse(names);
        System.out.println("redirect...");
        return "redirect:/statistic";
    }
  @GetMapping("/statistic")
    public String stats(Model model){
        model.addAttribute("heroes",names);
      model.addAttribute("images", new HeroList().getAllNameHeroes());
      model.addAttribute("winrates",Parse.INSTANCE.getWinrates());
      model.addAttribute("counters",Parse.INSTANCE.getCounters());
        return "statistic";
    }


}