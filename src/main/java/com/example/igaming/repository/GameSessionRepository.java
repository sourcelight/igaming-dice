package com.example.igaming.repository;

import com.example.igaming.data.entity.GameSession;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
@Repository
public interface GameSessionRepository extends R2dbcRepository<GameSession, Long> {

    Flux<GameSession> findByPlayer1(String player1);
    Flux<GameSession> findByPlayer2(String player2);
}