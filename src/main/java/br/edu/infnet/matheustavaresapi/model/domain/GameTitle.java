package br.edu.infnet.matheustavaresapi.model.domain;

import java.time.LocalDate;

public class GameTitle {
    public String name;
    public String publisher;
    public String platform;
    public LocalDate releaseDate;
    public float version;


    @Override
    public String toString() {
        String formatString = " Title: %s%n Publisher: %s%n Platform: %s%n Release Date: %s%n Version: % .1f" ;
        return String.format(formatString, name,publisher,platform,releaseDate,version);
    }
}

