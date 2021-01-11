package be.intecbrussel.foodshop.model;

import java.util.HashMap;
import java.util.Map;

public class Stock {
    private Map<Food, Integer> foodStock;

    public Stock() {
        this.foodStock = new HashMap<>();
    }

    public Map<Food, Integer> getFoodStock() {
        return foodStock;
    }

    public void setFoodStock(HashMap<Food, Integer> foodStock) {
        this.foodStock = foodStock;
    }

    public void addFood(Food food){
        if(food != null){
            foodStock.putIfAbsent(food, 1);
        }
    }

    public void removeFood(Food food){
        foodStock.remove(food);
    }

    public void addToStock(Food food, int amountToAdd){
        int newAmount = foodStock.get(food) + amountToAdd;
        foodStock.putIfAbsent(food, newAmount);
    }

    public void removeFromStock(Food food, int amountToRemove){
        if(foodStock.get(food) >= amountToRemove){
            int newAmount = foodStock.get(food) - amountToRemove;
            foodStock.putIfAbsent(food, newAmount);
        }
    }
}
