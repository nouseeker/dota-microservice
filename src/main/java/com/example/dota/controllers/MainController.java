package com.example.dota.controllers;

import com.example.dota.model.User;
import com.example.dota.piker.DotabuffParser;
import com.example.dota.piker.HeroList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Controller
public class MainController {

    final DotabuffParser dotabuffParse;
    User user;

    @Autowired
    public MainController(DotabuffParser dotabuffParse) {
        this.dotabuffParse = dotabuffParse;
    }


    @GetMapping("/counterpick*")
    public String getCounter(Model model, HttpServletRequest request) {
        String queryString = request.getQueryString();
        model.addAttribute("heroes", new HeroList().getAllNameHeroes());
        if (queryString != null && queryString.startsWith("?")) return "redirect:/counterpick";
        else
            return "counterpick";
    }

    @PostMapping("/selectHero")
    public String heroController(@RequestParam(value = "heroes", required = false) String[] names
                                 /*@RequestParam(value = "defCh", required = false) int def,
                                 @RequestParam(value = "rankCh", required = false) int rank,
                                 @RequestParam(value = "roleCh", required = false) int role,
                                 @RequestParam(value = "date", required = false) int date*/) {
        System.out.println("Основной поток");
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        long x = System.currentTimeMillis();
        dotabuffParse.setNames(names);
        executorService.submit(() -> {
            dotabuffParse.winrateParse();
        });
        dotabuffParse.counterParse();
        dotabuffParse.chance();
        executorService.shutdown();
        long y = System.currentTimeMillis();
        System.out.println("Время парсинга: " + (y - x));
        System.out.println("redirect...\n");
        return "redirect:/statistic";
    }

    @GetMapping("/statistic")
    public String stats(Model model) {
        try {
            model.addAttribute("heroes", dotabuffParse.getNames());
            model.addAttribute("images", new HeroList().getAllNameHeroes());
            model.addAttribute("winrates", dotabuffParse.getWinrates());
            model.addAttribute("counters", dotabuffParse.getCounters());
            model.addAttribute("disadvantage", dotabuffParse.getDisadvantage());
            model.addAttribute("chance", dotabuffParse.getChance());
            model.addAttribute("teamChance", dotabuffParse.getTeamChance());
            model.addAttribute("statsChance", dotabuffParse.getChanceTeam());
            return "statistic";
        } catch (NullPointerException e) {
            return "redirect:/counterpick";
        }
    }

    /*    @RequestMapping(value = "/username", method = RequestMethod.GET)
        @ResponseBody
        public String currentUserName(Authentication authentication) {
            return authentication.getName();
        }*/
    @ModelAttribute
    public void setNameForAllPages(Model model, Authentication authentication) {
        try {
            String name = authentication.getName();
            model.addAttribute("name", name);
        } catch (NullPointerException e) {
            System.out.println("User is not authenticated");
        }
    }


}