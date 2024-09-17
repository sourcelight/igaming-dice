package com.example.igaming.repository;

import com.example.igaming.data.entity.DiceRoll;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface DiceRollRepository extends ReactiveCrudRepository<DiceRoll, Long> {
    Flux<DiceRoll> findByUsername(String username);
}
