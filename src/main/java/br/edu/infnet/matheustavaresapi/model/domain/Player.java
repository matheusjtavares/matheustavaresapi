package br.edu.infnet.matheustavaresapi.model.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

@Entity
public class Player extends Person {

    private String tier;
    private double gamingTime;
    @Transient
    private Library library;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="favourite_platform_id")
    private Platform favouritePlatform;

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

}
