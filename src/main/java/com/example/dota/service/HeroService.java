package com.example.dota.service;

import com.example.dota.model.Hero;
import com.example.dota.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroService {
    private final HeroRepository heroRepository;

    @Autowired
    public HeroService(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    public List<Hero> getList() {
        return heroRepository.findAll();
    }
    public Hero saveHero(Hero hero){
        return heroRepository.save(hero);
    }
    public Hero findHeroById(int id){
        return heroRepository.getOne(id);
    }
    public String getWrById(int id, String rank) {
        String value ="0.0";
        switch (rank) {
            case "1":
                value = heroRepository.getById(id).getVerylow();
                break;

            case "2":
                value = heroRepository.getById(id).getLow();
                break;

            case "3":
                value = heroRepository.getById(id).getMedium();
                break;

            case "4":
                value = heroRepository.getById(id).getHigh();
                break;

            case "5":
                value = heroRepository.getById(id).getVeryhigh();
                break;
        }
        return value;
    }
}
