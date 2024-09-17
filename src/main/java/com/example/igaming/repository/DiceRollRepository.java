package com.example.igaming.repository;

import com.example.igaming.data.entity.DiceRoll;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface DiceRollRepository extends R2dbcRepository<DiceRoll, Long> {
    Flux<DiceRoll> findByUsername(String username);
}
