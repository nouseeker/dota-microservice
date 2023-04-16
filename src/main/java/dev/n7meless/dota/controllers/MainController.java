package com.example.dota.controllers;

import com.example.dota.model.History;
import com.example.dota.model.User;
import com.example.dota.piker.DotabuffParser;
import com.example.dota.piker.HeroList;
import com.example.dota.repository.UserRepository;
import com.example.dota.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


@Controller
public class MainController {

    final DotabuffParser dotabuffParse;
    final HistoryService historyService;
    final UserRepository userRepository;
    final PasswordEncoder passwordEncoder;

    @Autowired
    public MainController(DotabuffParser dotabuffParse, HistoryService historyService, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.dotabuffParse = dotabuffParse;
        this.historyService = historyService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
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
    public String heroController(@RequestParam(value = "heroes", required = false) String[] n
                                 /*@RequestParam(value = "defCh", required = false) int def,
                                 @RequestParam(value = "rankCh", required = false) int rank,
                                 @RequestParam(value = "date", required = false) int date*/, Authentication authentication) {
        dotabuffParse.setNames(n);
        long x = System.currentTimeMillis();
        User user = userRepository.findByEmail(authentication.getName()).get();
            dotabuffParse.winrateParse();
        dotabuffParse.counterParse();
        dotabuffParse.chance();
        historyService.saveHistory(new History(user, n[0], n[1], n[2], n[3], n[4], n[5], n[6], n[7], n[8], n[9], dotabuffParse.getTeamChance()));
        long y = System.currentTimeMillis();
        System.out.println("Время парсинга: " + (y - x));
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

    @GetMapping("/information")
    public String getInformation(Model model, Authentication authentication) {
        List<History> historyList = new ArrayList<>();
        User user = userRepository.findByEmail(authentication.getName()).get();
        try {
            historyList = historyService.getHistoryByOwner(user);
            model.addAttribute("histories", historyList);
        } catch (NoSuchElementException e) {
            model.addAttribute("histories", historyList);
        }
        model.addAttribute("images", new HeroList().getAllNameHeroes());
        model.addAttribute("user", user);
        return "information";
    }

    @GetMapping("/clearHistory")
    public String clearHistoryForm(Authentication authentication) {
        User user = userRepository.findByUsername(authentication.getName()).get();
        historyService.deleteByOwner(user);
        return "redirect:/information";
    }

    @ModelAttribute
    public void setNameForAllPages(Model model, Authentication authentication) {
        try {
            String name = authentication.getName();
            model.addAttribute("name", name);
        } catch (NullPointerException e) {
            System.out.println("User is not authenticated");
        }
    }

    @PostMapping("/update")
    public String changePassword(@RequestParam(value = "password", required = false)
                                 String password,
                                 @RequestParam(value = "newPassword", required = false)
                                 String newPassword, Model model, Authentication authentication) {
        User user = userRepository.findByUsername(authentication.getName()).get();
        if (passwordEncoder.matches(password, user.getPassword())) {
            user.setPassword(passwordEncoder.encode(newPassword));
            userRepository.save(user);
            return "redirect:/information";
        }
        System.out.println("password not saved");
        return "redirect:/information";
    }

}