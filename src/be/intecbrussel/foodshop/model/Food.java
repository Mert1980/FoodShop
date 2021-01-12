package be.intecbrussel.foodshop.model;

import java.io.Serializable;
import java.util.Objects;

public class Food implements Serializable {
    private String brand;
    private String name;
    private double price;
    private double calorie;

    public Food(String brand, String name, double price, double calorie) {
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.calorie = calorie;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCalorie() {
        return calorie;
    }

    public void setCalorie(double calorie) {
        this.calorie = calorie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Food))
            return false;
        Food food = (Food) o;
        return Double.compare(food.price, price) == 0 && Double.compare(food.calorie, calorie) == 0 && brand.equals(food.brand) && name.equals(food.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, name, price, calorie);
    }

    @Override
    public String toString() {
        return String.format("FOOD   Brand: %-10s  Name: %-10s  Price: %-15s  Calorie: %-5.2f€  ",
                brand, name, price, calorie);
    }
}
