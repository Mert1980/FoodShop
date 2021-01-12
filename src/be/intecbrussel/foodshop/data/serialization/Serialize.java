package be.intecbrussel.foodshop.data.serialization;

import be.intecbrussel.foodshop.model.FoodShop;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialize {
    public static void serialize(FoodShop foodShop){
        try(FileOutputStream file = new FileOutputStream("foodshop.ser");
            ObjectOutputStream out = new ObjectOutputStream(file)){
            out.writeObject(foodShop); // write drawing object to file
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
