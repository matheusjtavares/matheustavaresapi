package br.edu.infnet.matheustavaresapi.model.domain;

public class Player extends Person {

    private Library library;
    private String tier;
    private GameTitle favouriteGame;

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

    public GameTitle getFavouriteGame() {
        return favouriteGame;
    }

    public void setFavouriteGame(GameTitle favouriteGame) {
        this.favouriteGame = favouriteGame;
    }

}
