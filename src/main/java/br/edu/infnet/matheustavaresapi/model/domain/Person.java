package br.edu.infnet.matheustavaresapi.model.domain;

public abstract class Person {

    private int userID;
    private String name;
    private int age;
    private String String;
    private String email;
    private String phone;
    private String country;
    private boolean isActive;//default false

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", String=" + String + ", email=" + email + ", phone=" + phone
                + ", country=" + country + "]";
    }

    public abstract String getType();

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getString() {
        return String;
    }

    public void setString(String string) {
        String = string;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

}
