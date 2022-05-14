package com.example.dota.Piker;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Component
public class Hero {
    private int id;
    private int d=0;
    private int r=0;
    public Hero(){}

    List<String> direTeam = new ArrayList<>();
    List<String> radiantTeam = new ArrayList<>();
    List<String> allHeroes = Arrays.asList("Abaddon",
            "Alchemist",
            "Ancient Apparition",
            "Anti-Mage",
            "Arc Warden",
            "Axe",
            "Bane",
            "Batrider",
            "Beastmaster",
            "Bloodseeker",
            "Bounty Hunter",
            "Brewmaster",
            "Bristleback",
            "Broodmother",
            "Centaur Warrunner",
            "Chaos Knight",
            "Chen",
            "Clinkz",
            "Clockwerk",
            "Crystal Maiden",
            "Dark Seer",
            "Dark Willow",
            "Dawnbreaker",
            "Dazzle",
            "Death Prophet",
            "Disruptor",
            "Doom",
            "Dragon Knight",
            "Drow Ranger",
            "Earth Spirit",
            "Earthshaker",
            "Elder Titan",
            "Ember Spirit",
            "Enchantress",
            "Enigma",
            "Faceless Void",
            "Grimstroke",
            "Gyrocopter",
            "Hoodwink",
            "Huskar",
            "Invoker",
            "Io",
            "Jakiro",
            "Juggernaut",
            "Keeper of the Light",
            "Kunkka",
            "Legion Commander",
            "Leshrac",
            "Lich",
            "Lifestealer",
            "Lina",
            "Lion",
            "Lone Druid",
            "Luna",
            "Lycan",
            "Magnus",
            "Marci",
            "Mars",
            "Medusa",
            "Meepo",
            "Mirana",
            "Monkey King",
            "Morphling",
            "Naga Siren",
            "Nature's Prophet",
            "Necrophos",
            "Night Stalker",
            "Nyx Assassin",
            "Ogre Magi",
            "Omniknight",
            "Oracle",
            "Outworld Destroyer",
            "Pangolier",
            "Phantom Assassin",
            "Phantom Lancer",
            "Phoenix",
            "Primal Beast",
            "Puck",
            "Pudge",
            "Pugna",
            "Queen of Pain",
            "Razor",
            "Riki",
            "Rubick",
            "Sand King",
            "Shadow Demon",
            "Shadow Fiend",
            "Shadow Shaman",
            "Silencer",
            "Skywrath Mage",
            "Slardar",
            "Slark",
            "Snapfire",
            "Sniper",
            "Spectre",
            "Spirit Breaker",
            "Storm Spirit",
            "Sven",
            "Techies",
            "Templar Assassin",
            "Terrorblade",
            "Tidehunter",
            "Timbersaw",
            "Tinker",
            "Tiny",
            "Treant Protector",
            "Troll Warlord",
            "Tusk",
            "Underlord",
            "Undying",
            "Ursa",
            "Vengeful Spirit",
            "Venomancer",
            "Viper",
            "Visage",
            "Void Spirit",
            "Warlock",
            "Weaver",
            "Windranger",
            "Winter Wyvern",
            "Witch Doctor",
            "Wraith King",
            "Zeus");


    public void addDireTeam(String name){
        direTeam.add(d,name);
        d++;
    }
    public List<String> getDireTeam(){
        return direTeam;
    }
    public void addRadiantTeam(String name){
        radiantTeam.add(r,name);
        r++;
    }
    public int getRadiantCount(){
        return r;
    }
    public int getDireCount(){
        return d;
    }
    public List<String> getRadiantTeam(){
        return radiantTeam;
    }
    public boolean selectedHeroes(){
        if (radiantTeam.size()==5&&direTeam.size()==5){
            return true;
        }
        else return false;
    }


    public List<String> getArrayList(){
        return allHeroes;
    }
}
