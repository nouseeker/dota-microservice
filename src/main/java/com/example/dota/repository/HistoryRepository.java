package com.example.dota.repository;

import com.example.dota.model.History;
import com.example.dota.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {
    List<History> findAllByOwner(User user);

    void deleteByOwner(User user);
}
