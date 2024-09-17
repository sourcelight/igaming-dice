/**
 * @author: Riccardo_Bruno
 * @project: igaming-dice
 */

package com.example.igaming.service;

import com.example.igaming.data.entity.GameSession;
import com.example.igaming.repository.GameSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Random;


@Service
@RequiredArgsConstructor
public class GameSessionService {

    private  final GameSessionRepository gameSessionRepository;

    private Random random = new Random();




    // Start a new game session
    public Mono<GameSession> startGame(String player1) {
        GameSession gameSession = new GameSession();
        gameSession.setPlayer1(player1);
        gameSession.setCurrentPlayer(player1);
        return gameSessionRepository.save(gameSession);
    }

    // Join an existing game session
    public Mono<GameSession> joinGame(Long gameId, String player2) {
        return gameSessionRepository.findById(gameId).flatMap(gameSession -> {
            if (gameSession.getPlayer2() == null) {
                gameSession.setPlayer2(player2);
                return gameSessionRepository.save(gameSession);
            } else {
                return Mono.error(new RuntimeException("Game is already full"));
            }
        });
    }

    // Roll dice in a game session
    public Mono<GameSession> rollDice(GameSession gameSession, String currentPlayer) {
        if (!gameSession.isActive()) return Mono.just(gameSession); // If the game is already over.

        int dice1 = random.nextInt(6) + 1;
        int dice2 = random.nextInt(6) + 1;
        int total = dice1 + dice2;

        if (gameSession.getPlayer1().equals(currentPlayer)) {
            gameSession.setPlayer1Score(gameSession.getPlayer1Score() + total);
            gameSession.setCurrentPlayer(gameSession.getPlayer2());
        } else {
            gameSession.setPlayer2Score(gameSession.getPlayer2Score() + total);
            gameSession.setCurrentPlayer(gameSession.getPlayer1());
        }

        // Terminate the game if a player reaches a certain score
        if (gameSession.getPlayer1Score() >= 50 || gameSession.getPlayer2Score() >= 50) {
            gameSession.setActive(false);
        }

        return gameSessionRepository.save(gameSession);
    }

    // Get a game session by ID
    public Mono<GameSession> getGameSession(Long gameId) {
        return gameSessionRepository.findById(gameId);
    }

    // Get all game sessions by a player
    public Flux<GameSession> getAllGameSessionsByPlayer(String player) {
        return gameSessionRepository.findByPlayer1(player)
                .concatWith(gameSessionRepository.findByPlayer2(player));
    }
}