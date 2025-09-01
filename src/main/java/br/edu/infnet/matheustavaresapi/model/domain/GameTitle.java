package br.edu.infnet.matheustavaresapi.model.domain;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class GameTitle {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String publisher;
    private String platform;
    private LocalDate releaseDate;
    private float version;
    private Boolean isActive;


    @Override
    public String toString() {
        String formatString = " Title: %s%n Publisher: %s%n Platform: %s%n Release Date: %s%n Version: % .1f" ;
        return String.format(formatString, name,publisher,platform,releaseDate,version);
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getPublisher() {
        return publisher;
    }


    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }


    public String getPlatform() {
        return platform;
    }


    public void setPlatform(String platform) {
        this.platform = platform;
    }


    public LocalDate getReleaseDate() {
        return releaseDate;
    }


    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }


    public float getVersion() {
        return version;
    }


    public void setVersion(float version) {
        this.version = version;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}

