package com.example.dota.service;

import com.example.dota.model.History;
import com.example.dota.model.User;
import com.example.dota.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HistoryService {
    private final HistoryRepository historyRepository;

    @Autowired
    public HistoryService(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @Transactional
    @Scope(proxyMode = ScopedProxyMode.INTERFACES)
    public void deleteByOwner(User user) {
        historyRepository.deleteByOwner(user);
    }

    public History saveHistory(History history) {
        return historyRepository.save(history);
    }

    public List<History> getHistoryByOwner(User user) {
        return historyRepository.findAllByOwner(user);
    }
}
