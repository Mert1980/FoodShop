package be.intecbrussel.foodshop.model;

import java.util.Map;
import java.util.Set;

public class Order {
    private Map<Food, Integer> foodItems;
    private double percentDiscount;

    public Order(Map<Food, Integer> foodItems, double percentDiscount) {
        this.foodItems = foodItems;
        this.percentDiscount = percentDiscount;
    }

    public Map<Food, Integer> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(Map<Food, Integer> foodItems) {
        this.foodItems = foodItems;
    }

    public double getDiscount() {
        return percentDiscount;
    }

    public double applyDiscount(double percent) {
        return getTotalPrice() * (1 - (percent / 100));
    }

    public double getTotalPrice(){
        Set<Food> foodSet = foodItems.keySet();
        double totalPrice = foodSet.stream()
                .mapToDouble(Food::getPrice)
                .sum();
        return totalPrice;
    }
}
