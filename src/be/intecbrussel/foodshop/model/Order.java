package be.intecbrussel.foodshop.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Order {
    private Map<Food, Integer> foodItems;
    private double percentDiscount;

    public Order() {
        this.foodItems = new HashMap<>();
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
        // obtain a set of key-value pairs:
        Set<Map.Entry<Food, Integer>> foodSet = foodItems.entrySet();

        double totalPrice = foodSet.stream()
                .map(food -> food.getKey().getPrice() * food.getValue())
                .reduce(0.0, (acc, el) -> acc + el);
        return totalPrice;
    }
}
