package be.intecbrussel.foodshop.app;

import be.intecbrussel.foodshop.exception.NotEnoughMoneyException;
import be.intecbrussel.foodshop.model.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
        Register register = new Register();
        register.addMoney(1000);

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
        order.applyDiscount(50);
        System.out.println("Total discounted price of order: " + order.getTotalPrice());

        // print sold food
        try {
            foodShop.sellFood(order, customer1)
                    .entrySet()
                    .forEach(System.out::println);
        } catch (NotEnoughMoneyException e) {
            e.printStackTrace();
        }

        // write stock to a file
        Path path = Paths.get("FoodStock.txt");
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("FoodStock.txt", true))){
            Set<Map.Entry<Food, Integer>> foodSet = foodStock.entrySet();
            foodSet.forEach(item -> {
                try {
                    writer.write(item.getKey().toString() + " " + item.getValue() + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

        } catch (IOException ex){
            System.out.println("Oops, something went wrong!");
            System.out.println(ex.getMessage());
        }
        // read the file line by line
        try(BufferedReader reader = Files.newBufferedReader(path)) {
            String line = null;
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException ex){
            System.out.println("Oops, something went wrong!");
            System.out.println(ex.getMessage());
        }

    }
}
