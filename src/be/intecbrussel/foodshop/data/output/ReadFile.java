package be.intecbrussel.foodshop.data.output;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadFile {
    public static void read(){
        // read the file line by line
        Path path = Paths.get("FoodStock.txt");

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
