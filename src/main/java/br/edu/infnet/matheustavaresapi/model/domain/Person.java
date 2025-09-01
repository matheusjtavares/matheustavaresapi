package br.edu.infnet.matheustavaresapi.model.domain;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@MappedSuperclass
public abstract class Person {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message="Name cannot be null")
    @Size(min=3,max=50,message = "Name length must be between 3 and 50")
    private String name;
    @Min(0)
    private int age;
    @NotBlank(message="Email cannot be null")
    @Email(message="This email is not valid")
    private String email;
    @NotBlank(message="Country cannot be null")
    private String country;
    private boolean isActive;//default false

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", email=" + email +
                ", country=" + country + "]";
    }

    public abstract String getType();

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


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
