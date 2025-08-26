package br.edu.infnet.matheustavaresapi.model.domain;

public class Person {
    public int userID;
    public String name; //default null
    public int age;//default 0
    public boolean isActive;//default false
    public String email;
    public String country;

    @Override
    public String toString() {
        String formatString = "User: %s%nAge: %d%nEmail:%s%n Country: %s%n Status: %s";
        return String.format(formatString, name,age,email,country, (isActive == true) ? "Active" :"Inactive");
    }
}
