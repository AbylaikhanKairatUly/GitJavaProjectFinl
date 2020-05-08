package sample;

import java.io.Serializable;
import java.util.ArrayList;

public class Order implements Serializable {
    private int id;
    private String location;
    private String address;
    private String conditioner;
    private  String quick;
    private String child;
    private int offer;
    private String type;
    private String number;
    private String accepted;



    public Order() {

    }

    public Order(String accepted) {
        this.accepted=accepted;
    }


    public Order(String location, String address, String number, String type, int offer, String conditioner, String childSeat, String quick) {
        this.location = location;
        this.address = address;
        this.number=number;
        this.type=type;
        this.offer = offer;
        this.conditioner = conditioner;
        this.child = childSeat;
        this.quick = quick;
    }

    public Order(int idorder, String location, String address, String number, String type, int offer, String conditioner, String child_seat, String quick) {
        this.id=idorder;
        this.location = location;
        this.address = address;
        this.number=number;
        this.type=type;
        this.offer = offer;
        this.conditioner = conditioner;
        this.child = child_seat;
        this.quick = quick;
    }

    public Order(String location, String address, String number, String offer) {
    }

    public Order(String location, String address, String number, String type, String offer) {
        this.location = location;
        this.address = address;
        this.number=number;
        this.type=type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getConditioner() {
        return conditioner;
    }

    public void setConditioner(String conditioner) {
        this.conditioner = conditioner;
    }

    public String getQuick() {
        return quick;
    }

    public void setQuick(String quick) {
        this.quick = quick;
    }

    public String getChild() {
        return child;
    }

    public void setChild(String child) {
        this.child = child;
    }

    public int getOffer() {
        return offer;
    }

    public void setOffer(int offer) {
        this.offer = offer;
    }

    @Override
    public String toString() {
        return accepted;
    }
}

