package sample;

import java.io.Serializable;

public class Driver implements Serializable {
    private int index;
    private  String name;
    private String surname;
    private String iin;
    private String carModel;
    private String carNumber;
    private String number;
    private String password;

    public Driver(){

    }
    public Driver(String name, String surname, String iin, String carModel, String carNumber, String number, String password) {
        this.name = name;
        this.surname = surname;
        this.iin = iin;
        this.carModel = carModel;
        this.carNumber = carNumber;
        this.number = number;
        this.password = password;
    }

    public Driver(String name, String number, String carModel, String carNumber) {
        this.name = name;
        this.carModel = carModel;
        this.carNumber = carNumber;
        this.number = number;
    }

    public Driver(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Driver's name:" + name +" \n "+ "Driver number:"+ number +"\n"+"Car Model:" + carModel + "\n" + "Car number:" + carNumber ;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
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

    public String getIin() {
        return iin;
    }

    public void setIin(String iin) {
        this.iin = iin;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
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
}
