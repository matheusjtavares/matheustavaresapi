package br.edu.infnet.matheustavaresapi.model.domain;

import java.time.LocalDate;

public class Platform {
    private int id;
    private String name;
    private String manufacturer;
    private LocalDate releaseDate;
    private double price;
    private boolean isHandheld;

    @Override
    public String toString() {
        String formatString = " Name: %s%n Manufacurer: %s%n Release Date: %s%n Price: % .2f%n Type: %s";
        return String.format(formatString, name,manufacturer,releaseDate,price, (isHandheld == true) ? "Handheld" :"Desk");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isHandheld() {
        return isHandheld;
    }

    public void setHandheld(boolean isHandheld) {
        this.isHandheld = isHandheld;
    }
}
