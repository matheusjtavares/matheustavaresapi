package br.edu.infnet.matheustavaresapi.model.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
public class Player extends Person {


    private String tier;

    @Min(value = 0, message = "Gaming time cannot be negative")
    private double gamingTime;

    @Transient
    private Library library;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "favourite_platform_id")
    @Valid
    @NotNull(message = "Favourite platform cannot be null")
    private Platform favouritePlatform;

    @OneToMany(mappedBy="player",cascade=CascadeType.ALL, orphanRemoval=true,fetch=FetchType.LAZY)
    private List<GameCopy> gameCopies = new ArrayList<>();

    @Override
    public String toString() {
        // String formatString = "User: %s%nAge: %d%nEmail:%s%n Country: %s%n Status: %s";
        // return String.format(formatString, getName(),
        // getEmail(),getCountry(), (isIsActive() == true) ? "Active" :"Inactive");
        String formatString = "%s";
        return String.format(formatString,
                super.toString());

    }

    @Override
    public String getType() {
        return "Player";
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public Platform getFavouritePlatform() {
        return favouritePlatform;
    }

    public void setFavouritePlatform(Platform favouritePlatform) {
        this.favouritePlatform = favouritePlatform;
    }

    public double getGamingTime() {
        return gamingTime;
    }

    public void setGamingTime(double gamingTime) {
        this.gamingTime = gamingTime;
    }

    public List<GameCopy> getGameCopies() {
        return gameCopies;
    }

    public void setGameCopies(List<GameCopy> gameCopies) {
        this.gameCopies = gameCopies;
    }

}
