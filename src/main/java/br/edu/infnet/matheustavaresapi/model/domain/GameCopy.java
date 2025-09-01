package br.edu.infnet.matheustavaresapi.model.domain;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

@Entity
public class GameCopy {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Valid
    @NotNull(message = "GameTitle platform cannot be null")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="gameT_title_id", nullable=false)
    public GameTitle gameTitle;

    @NotNull(message = "Owned Since Date cannot be null")
    @PastOrPresent(message = "Owned Since Date cannot be in the future")
    public LocalDate ownedSinceDate;
    
    @Valid
    @NotNull(message = "Player Cannot be null")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="player_id", nullable=false)
    public Player player;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public GameTitle getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(GameTitle gameTitle) {
        this.gameTitle = gameTitle;
    }

    public LocalDate getOwnedSinceDate() {
        return ownedSinceDate;
    }

    public void setOwnedSinceDate(LocalDate ownedSinceDate) {
        this.ownedSinceDate = ownedSinceDate;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    
}
