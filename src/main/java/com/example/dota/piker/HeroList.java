package com.example.dota.piker;


import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
@Component
public class HeroList{
    private int id;

    public HeroList() {
    }

    List<String> dire;
    List<String> radiant;
    List<String> allNameHeroes = Arrays.asList("Abaddon", "Alchemist", "Ancient Apparition", "Anti-Mage", "Arc Warden", "Axe", "Bane", "Batrider", "Beastmaster", "Bloodseeker", "Bounty Hunter", "Brewmaster", "Bristleback", "Broodmother", "Centaur Warrunner", "Chaos Knight", "Chen", "Clinkz", "Clockwerk", "Crystal Maiden", "Dark Seer", "Dark Willow", "Dawnbreaker", "Dazzle", "Death Prophet", "Disruptor", "Doom", "Dragon Knight", "Drow Ranger", "Earth Spirit", "Earthshaker", "Elder Titan", "Ember Spirit", "Enchantress", "Enigma", "Faceless Void", "Grimstroke", "Gyrocopter", "Hoodwink", "Huskar", "Invoker", "Io", "Jakiro", "Juggernaut", "Keeper of the Light", "Kunkka", "Legion Commander", "Leshrac", "Lich", "Lifestealer", "Lina", "Lion", "Lone Druid", "Luna", "Lycan", "Magnus", "Marci", "Mars", "Medusa", "Meepo", "Mirana", "Monkey King", "Morphling", "Naga Siren", "Nature's Prophet", "Necrophos", "Night Stalker", "Nyx Assassin", "Ogre Magi", "Omniknight", "Oracle", "Outworld Destroyer", "Pangolier", "Phantom Assassin", "Phantom Lancer", "Phoenix", "Primal Beast", "Puck", "Pudge", "Pugna", "Queen of Pain", "Razor", "Riki", "Rubick", "Sand King", "Shadow Demon", "Shadow Fiend", "Shadow Shaman", "Silencer", "Skywrath Mage", "Slardar", "Slark", "Snapfire", "Sniper", "Spectre", "Spirit Breaker", "Storm Spirit", "Sven", "Techies", "Templar Assassin", "Terrorblade", "Tidehunter", "Timbersaw", "Tinker", "Tiny", "Treant Protector", "Troll Warlord", "Tusk", "Underlord", "Undying", "Ursa", "Vengeful Spirit", "Venomancer", "Viper", "Visage", "Void Spirit", "Warlock", "Weaver", "Windranger", "Winter Wyvern", "Witch Doctor", "Wraith King", "Zeus");
    List<String> allLinkHeroes = Arrays.asList(
            "abaddon",
            "alchemist",
            "ancient-apparition",
            "anti-mage",
            "arc-warden",
            "axe",
            "bane",
            "batrider",
            "beastmaster",
            "bloodseeker",
            "bounty-hunter",
            "brewmaster",
            "bristleback",
            "broodmother",
            "centaur-warrunner",
            "chaos-knight",
            "chen",
            "clinkz",
            "clockwerk",
            "crystal-maiden",
            "dark-seer",
            "dark-willow",
            "dawnbreaker",
            "dazzle",
            "death-prophet",
            "disruptor",
            "doom",
            "dragon-knight",
            "drow-ranger",
            "earth-spirit",
            "earthshaker",
            "elder-titan",
            "ember-spirit",
            "enchantress",
            "enigma",
            "faceless-void",
            "grimstroke",
            "gyrocopter",
            "hoodwink",
            "huskar",
            "invoker",
            "io",
            "jakiro",
            "juggernaut",
            "keeper-of-the-light",
            "kunkka",
            "legion-commander",
            "leshrac",
            "lich",
            "lifestealer",
            "lina",
            "lion",
            "lone-druid",
            "luna",
            "lycan",
            "magnus",
            "marci",
            "mars",
            "medusa",
            "meepo",
            "mirana",
            "monkey-king",
            "morphling",
            "naga-siren",
            "natures-prophet",
            "necrophos",
            "night-stalker",
            "nyx-assassin",
            "ogre-magi",
            "omniknight",
            "oracle",
            "outworld-destroyer",
            "pangolier",
            "phantom-assassin",
            "phantom-lancer",
            "phoenix",
            "primal-beast",
            "puck",
            "pudge",
            "pugna",
            "queen-of-pain",
            "razor",
            "riki",
            "rubick",
            "sand-king",
            "shadow-demon",
            "shadow-fiend",
            "shadow-shaman",
            "silencer",
            "skywrath-mage",
            "slardar",
            "slark",
            "snapfire",
            "sniper",
            "spectre",
            "spirit-breaker",
            "storm-spirit",
            "sven",
            "techies",
            "templar-assassin",
            "terrorblade",
            "tidehunter",
            "timbersaw",
            "tinker",
            "tiny",
            "treant-protector",
            "troll-warlord",
            "tusk",
            "underlord",
            "undying",
            "ursa",
            "vengeful-spirit",
            "venomancer",
            "viper",
            "visage",
            "void-spirit",
            "warlock",
            "weaver",
            "windranger",
            "winter-wyvern",
            "witch-doctor",
            "wraith-king",
            "zeus"
    );


    void setRadiant(String name) {

    }

    void setDire(String name) {

    }

    public List<String> getRadiant() {
        return null;
    }

    public List<String> getDire() {
        return null;
    }

    public List<String> getAllNameHeroes() {
        return allLinkHeroes;
    }
}




