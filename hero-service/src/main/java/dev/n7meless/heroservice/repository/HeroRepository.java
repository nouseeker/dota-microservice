package dev.n7meless.heroservice.repository;

import dev.n7meless.heroservice.dto.Hero;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends MongoRepository<Hero, Long> {

}
