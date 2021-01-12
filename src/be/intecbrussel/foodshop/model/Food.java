package be.intecbrussel.foodshop.model;

public class Food {
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
    public String toString() {
        return String.format("FOOD   Brand: %-10s  Name: %-10s  Price: %-15s  Calorie: %-5.2f€  ",
                brand, name, price, calorie);
    }
}
