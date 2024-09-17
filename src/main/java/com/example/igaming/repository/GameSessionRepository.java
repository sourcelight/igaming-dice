package com.example.igaming.repository;

import com.example.igaming.data.entity.GameSession;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

public interface GameSessionRepository extends ReactiveCrudRepository<GameSession, Long> {

    Flux<GameSession> findByPlayer1(String player1);
    Flux<GameSession> findByPlayer2(String player2);
}