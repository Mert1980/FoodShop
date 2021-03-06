package be.intecbrussel.foodshop.model;

import java.io.Serializable;

public class Customer implements Serializable {
    private String name;
    private int ID;
    private String email;
    private double money;

    public Customer(){
        this("", 0, "", 0);
    }

    public Customer(String name, int ID, String email, double money) {
        this.name = name;
        this.ID = ID;
        this.email = email;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return String.format("CUSTOMER   Name: %-10s  ID: %-10s  E-mail: %-15s  Money: %-5.2f€  ",
                name, ID, email, money);
    }
}
