package com.example.dota.service;

import com.example.dota.model.History;
import com.example.dota.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {
    private HistoryRepository historyRepository;
    @Autowired
    public HistoryService(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    public History saveHistory(History history) {
        return historyRepository.save(history);
    }
    public int[] getHeroesId(){
        historyRepository.ge
    }
}
