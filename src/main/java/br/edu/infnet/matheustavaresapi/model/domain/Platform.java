package br.edu.infnet.matheustavaresapi.model.domain;

import java.time.LocalDate;

public class Platform {
    public String name;
    public String manufacturer;
    public LocalDate releaseDate;
    public double price;
    public boolean isHandheld;

    @Override
    public String toString() {
        String formatString = " Name: %s%n Manufacurer: %s%n Release Date: %s%n Price: % .2f%n Type: %s";
        return String.format(formatString, name,manufacturer,releaseDate,price, (isHandheld == true) ? "Handheld" :"Desk");
    }
}
