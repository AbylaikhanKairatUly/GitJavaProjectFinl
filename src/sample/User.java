package sample;

import java.io.Serializable;

public class User implements Serializable {
    private  String name;
    private String surname;
    private String email;
    private String number;
    private String password;

    public User(String name, String surname, String email, String number, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.number = number;
        this.password = password;
    }

    public User(String name, String surname, String IIN, String carModel, String carNumber, String number, String password) {

    }
    public User() {

    }

    public User(String number) {
        this.number=number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", number='" + number + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
