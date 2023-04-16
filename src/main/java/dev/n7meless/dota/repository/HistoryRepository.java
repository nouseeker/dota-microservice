package dev.n7meless.dota.repository;

import dev.n7meless.dota.model.History;
import dev.n7meless.dota.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {
    List<History> findAllByOwner(User user);

    void deleteByOwner(User user);
}
