package com.example.dota.controllers;

import com.example.dota.Piker.Hero;
import com.example.dota.Piker.Parse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Controller
public class MainController {
    Hero hero = new Hero();

    Parse parse = new Parse();
    double chanceRadiant=0.0;
    List<String> heroes=new ArrayList<>(hero.getArrayList());

    @GetMapping("/")
    public String greeting(Model model) {
        model.addAttribute("heroes", heroes);
        model.addAttribute("wrHeroes", parse.getHeroWr());
        model.addAttribute("rHeroes", hero.getRadiantTeam());
        model.addAttribute("dHeroes", hero.getDireTeam());
        model.addAttribute("parse", parse);
        model.addAttribute("hero", hero);
        if(hero.selectedHeroes()){
        for (int i = 0; i < 25; i++) {
            model.addAttribute("id"+String.valueOf(i), parse.getValsById(i));
            model.addAttribute("wr"+String.valueOf(i), parse.getWrById(i));
            chanceRadiant = chanceRadiant + Double.parseDouble(parse.getWrById(i).substring(0,5));
        }
        model.addAttribute("chanceRadiant", "Radiant team have: "+(String.format("%.2f",chanceRadiant-1250))+"% to win");
        model.addAttribute("chanceDire", "Dire team have: "+(1250-chanceRadiant)+"% to win");
        }
        return "home";
    }

    @PostMapping( "/selectHero")
    public String s(@RequestParam(value = "hero", required = false) String name, Model model) {
            if(hero.getRadiantCount()<5){
                hero.addRadiantTeam(name);
            }
            else if(hero.getDireCount()<5){
                hero.addDireTeam(name);
            }
            if(hero.selectedHeroes()){
                parse.parseValue(hero.getRadiantTeam(), hero.getDireTeam());
            }
            System.out.println(name);
            heroes.remove(name);

        return "redirect:/";
    }



}