/**
 * @author: Riccardo_Bruno
 * @project: igaming-dice
 */
package com.example.igaming.data.entity;

import jakarta.persistence.*;
import org.springframework.data.relational.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "game_session")
public class GameSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "player_1")
    private String player1;
    @Column(nullable = false, name = "player_2")
    private String player2;
    @Column(nullable = false, name = "current_palyer")
    private String currentPlayer;
    @Column(nullable = false, name = "player_score_1")
    private Integer player1Score = 0;
    @Column(nullable = false, name = "player_score_2")
    private Integer player2Score = 0;
    @Column(nullable = false, name = "active")
    private boolean active = true;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(String currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Integer getPlayer1Score() {
        return player1Score;
    }

    public void setPlayer1Score(Integer player1Score) {
        this.player1Score = player1Score;
    }

    public Integer getPlayer2Score() {
        return player2Score;
    }

    public void setPlayer2Score(Integer player2Score) {
        this.player2Score = player2Score;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
