package br.edu.infnet.matheustavaresapi.model.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Entity
public class GameTitle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 3, max = 50, message = "The name must be between 3 and 50 characters")
    private String name;

    @NotBlank(message = "Publisher cannot be blank")
    @Size(min = 1, max = 200, message = "The publisher name must be between 5 and 50 characters")
    private String publisher;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "platform_id")
    @Valid
    @JsonBackReference("platform-gameTitles")
    @NotNull(message = "Favourite platform cannot be null")
    private Platform platform;

    @NotNull(message = "Release Date cannot be null")
    @PastOrPresent(message = "Release Date cannot be in the future")
    private LocalDate releaseDate;

    @NotNull(message = "Version cannot be null")
    @PositiveOrZero(message = "Version cannot be negative")
    private Float version;

    @NotNull(message = "isActive cannot be null")
    private Boolean isActive;

    @OneToMany(mappedBy="gameTitle",cascade=CascadeType.ALL, orphanRemoval=true,fetch=FetchType.EAGER)
    @JsonManagedReference(value="gameTitle-gameCopy")
    private List<GameCopy> gameCopies = new ArrayList<>();

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


    public Platform getPlatform() {
        return platform;
    }


    public void setPlatform(Platform platform) {
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

    public List<GameCopy> getGameCopies() {
        return gameCopies;
    }

    public void setGameCopies(List<GameCopy> gameCopies) {
        this.gameCopies = gameCopies;
    }
}

