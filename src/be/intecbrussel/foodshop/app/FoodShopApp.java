package be.intecbrussel.foodshop.app;

import be.intecbrussel.foodshop.data.input.WriteFile;
import be.intecbrussel.foodshop.data.output.ReadFile;
import be.intecbrussel.foodshop.data.serialization.Deserialize;
import be.intecbrussel.foodshop.data.serialization.Serialize;
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

        // write stock to a file
        WriteFile.write(foodStock);

        // read stock from file
        System.out.println("--------------------READ FROM FILE-----------------------");
        ReadFile.read();

        // serialize
        Serialize.serialize(foodShop);

        // deserialize
        System.out.println("---------------------AFTER DESERIALIZATION------------------");
        Deserialize.deserialize((foodShop));

    }
}
