package be.intecbrussel.foodshop.app;

import be.intecbrussel.foodshop.data.input.WriteFile;
import be.intecbrussel.foodshop.data.output.ReadFile;
import be.intecbrussel.foodshop.data.serialization.Deserialize;
import be.intecbrussel.foodshop.data.serialization.Serialize;
import be.intecbrussel.foodshop.exception.FoodAlreadyInStockException;
import be.intecbrussel.foodshop.exception.FoodNotInStockException;
import be.intecbrussel.foodshop.exception.NotEnoughFoodInStockException;
import be.intecbrussel.foodshop.exception.NotEnoughMoneyException;
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

        // create food to stock
        try {
            stock.addFood(pizza);
        } catch (FoodAlreadyInStockException e) {
            e.printStackTrace();
        }
        try {
            stock.addFood(hamburger);
        } catch (FoodAlreadyInStockException e) {
            e.printStackTrace();
        }

        // add food to stock
        try {
            stock.addToStock(pizza, 10);
        } catch (FoodNotInStockException e) {
            e.printStackTrace();
        }

        try {
            stock.addToStock(hamburger, 10);
        } catch (FoodNotInStockException e) {
            e.printStackTrace();
        }

        // print stock
        System.out.println("---------------STOCK---------------");
        stock.getFoodStock().entrySet().forEach(System.out::println);

        // create food shop
        FoodShop foodShop = new FoodShop(stock);

        // create register
        Register register = new Register();
        register.addMoney(1000);

        // create order
        Order order = new Order();
        order.addFoodToOrder(pizza, 2);
        order.addFoodToOrder(hamburger, 3);

        // print order
        System.out.println("---------------ORDER---------------");
        order.getFoodItems().entrySet()
                .forEach(System.out::println);

        // calculate total price
        double totalPrice = order.getTotalPrice();
        System.out.println("Total price of order: " + totalPrice);

        // calculate discounted price
        order.applyDiscount(50);
        System.out.println("Total discounted price of order: " + order.getTotalPrice());

        // print sold food
        System.out.println("-------------------SOLD FOOD--------------------------");
        try {
            foodShop.sellFood(order, customer1)
                    .entrySet()
                    .forEach(System.out::println);
        } catch (NotEnoughMoneyException e) {
            e.printStackTrace();
        } catch (FoodNotInStockException e) {
            e.printStackTrace();
        } catch (NotEnoughFoodInStockException e) {
            e.printStackTrace();
        }

        // print stock after order
        System.out.println("---------------STOCK---------------");
        stock.getFoodStock().entrySet().forEach(System.out::println);

        // write stock to a file
        WriteFile.write(stock.getFoodStock());

        // read stock from file
        System.out.println("--------------------READ FROM FILE-----------------------");
        ReadFile.read();

        // serialize
        Serialize.serialize(foodShop);

        pizza.setPrice(15);

        // deserialize
        System.out.println("---------------------AFTER DESERIALIZATION------------------");
        Deserialize.deserialize((foodShop));

        // print stock after deserialization
        System.out.println("---------------STOCK---------------");
        stock.getFoodStock().entrySet().forEach(System.out::println);

    }
}
