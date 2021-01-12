package be.intecbrussel.foodshop.data.serialization;

import be.intecbrussel.foodshop.model.FoodShop;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserialize {
    public static void deserialize(FoodShop foodShop){
        try (FileInputStream file = new FileInputStream("foodshop.ser");
             ObjectInputStream in = new ObjectInputStream(file)) {
            // read Drawing object from file
            foodShop = (FoodShop) in.readObject();
            // print stock on the terminal
            foodShop.getStock()
                    .getFoodStock()
                    .entrySet()
                    .forEach(System.out::println);
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException cnfe){
            System.out.println(cnfe.getException());
        }
    }
}
