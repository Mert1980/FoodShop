package be.intecbrussel.foodshop.app;

import be.intecbrussel.foodshop.model.*;

import java.util.HashMap;

public class FoodShopApp {
    public static void main(String[] args) {
        // create customer
        Customer customer1 = new Customer("Mert", 12345, "mertdemirok80@gmail.com", 1000);
        System.out.println(customer1);
        // create foods
        Food pizza = new Food("Dominos", "Margarita", 10.5, 450);
        Food hamburger = new Food("KFC", "nuggets", 7.5, 500);

        // create stock of food
        Stock stock = new Stock();
        HashMap<Food, Integer> foodStock = new HashMap<>();
        foodStock.putIfAbsent(pizza, 10);
        foodStock.putIfAbsent(hamburger, 10);
        stock.setFoodStock(foodStock);

        // create food shop
        FoodShop foodShop = new FoodShop();
        foodShop.setStock(stock);

        // create register
        Register register = new Register(500);

        // create order
        HashMap<Food, Integer> orderList = new HashMap<>();
        orderList.putIfAbsent(pizza, 2);
        orderList.putIfAbsent(hamburger, 3);

        Order order = new Order();
        order.setFoodItems(orderList);

        // print order
        order.getFoodItems().entrySet()
                .forEach(System.out::println);

        // calculate total price
        double totalPrice = order.getTotalPrice();
        System.out.println("Total price of order: " + totalPrice);

        // calculate discounted price
        double discountedPrice = order.applyDiscount(50);
        System.out.println("Total discounted price of order: " + discountedPrice);

        // print sold food
        foodShop.sellFood(order, customer1)
                .entrySet()
                .forEach(System.out::println);

    }
}
