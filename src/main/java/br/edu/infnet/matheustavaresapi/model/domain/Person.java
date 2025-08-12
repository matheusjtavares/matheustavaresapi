package br.edu.infnet.matheustavaresapi.model.domain;

public class Person {
    public String name; //default null
    public int age;//default 0
    public double activity; //default 0.0
    public boolean isActive;//default false

    @Override
    public String toString() {
        String formatString = "User: %s%nAge: %d%nActivity: %.2f Hours%nStatus: %s";
        return String.format(formatString, name,age,activity, (isActive == true) ? "Active" :"Inactive");
    }
}
