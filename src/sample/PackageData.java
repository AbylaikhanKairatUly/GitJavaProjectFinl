package sample;

import javafx.scene.control.TableColumn;

import java.io.Serializable;
import java.util.ArrayList;

public class PackageData implements Serializable {
    private String operationType;// ADD, LIST
    private int idOrd;
    private String numD;
    private User user;
    private Order order;
    private ArrayList<Order> orders;
    private Driver driver;
    private ArrayList<Driver> drivers;




    public PackageData(String operationType, User user) {
        this.operationType = operationType;
        this.user = user;
    }

    public PackageData(String operationType, Order order) {
        this.operationType = operationType;
        this.order = order;
    }

    public PackageData(String operationType,Driver driver) {
        this.operationType = operationType;
        this.driver = driver;
    }


    public PackageData(String reception, int idOrder, ArrayList<Driver> arrDrivers) {
        this.operationType = reception;
        this.idOrd=idOrder;
        this.drivers=arrDrivers;
    }

    public PackageData(String operationType,String numD) {
        this.operationType = operationType;
        this.numD = numD;
    }

    public PackageData(ArrayList<Order> arrMessage) {
        this.orders=arrMessage;
    }
    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public ArrayList<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(ArrayList<Driver> drivers) {
        this.drivers = drivers;
    }

    public String getNum() {
        return numD;
    }

    public void setNum(String num) {
        this.numD = num;
    }


    public int getIdOrd() {
        return idOrd;
    }

    public void setIdOrd(int idOrd) {
        this.idOrd = idOrd;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
