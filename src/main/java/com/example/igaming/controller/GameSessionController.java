/**
 * @author: Riccardo_Bruno
 * @project: igaming-dice
 */


package com.example.igaming.controller;

import com.example.igaming.data.entity.GameSession;
import com.example.igaming.service.GameSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.security.Principal;

@RestController
@RequestMapping("/api/games")
public class GameSessionController {

    @Autowired
    private GameSessionService gameSessionService;

    @PostMapping("/start")
    public Mono<GameSession> startGame(Principal principal) {
        return gameSessionService.startGame(principal.getName());
    }

    @PostMapping("/join/{gameId}")
    public Mono<GameSession> joinGame(@PathVariable Long gameId, Principal principal) {
        return gameSessionService.joinGame(gameId, principal.getName());
    }

    @PostMapping("/roll")
    public Mono<GameSession> rollDice(@RequestBody GameSession gameSession, Principal principal) {
        return gameSessionService.rollDice(gameSession, principal.getName());
    }

    @GetMapping("/{gameId}")
    public Mono<GameSession> getGameSession(@PathVariable Long gameId) {
        return gameSessionService.getGameSession(gameId);
    }

    @GetMapping("/player")
    public Flux<GameSession> getAllGameSessionsByPlayer(Principal principal) {
        return gameSessionService.getAllGameSessionsByPlayer(principal.getName());
    }
}