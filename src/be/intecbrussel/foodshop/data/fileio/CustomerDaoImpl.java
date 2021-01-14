package be.intecbrussel.foodshop.data.fileio;

import be.intecbrussel.foodshop.config.FilePaths;
import be.intecbrussel.foodshop.data.CustomerDao;
import be.intecbrussel.foodshop.model.Customer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CustomerDaoImpl implements CustomerDao {
    Customer customer = new Customer();

    @Override
    public Customer readCustomer() {
        Path path = Paths.get(FilePaths.CUSTOMER_FILEPATH.getFile().getPath());

        try(BufferedReader reader = Files.newBufferedReader(path)) {
            String line = null;

            while((line = reader.readLine()) != null){
                String[] parts = line.split(",");
                customer.setName(parts[0]);
                customer.setID(Integer.valueOf(parts[1]));
                customer.setEmail(parts[2]);
                customer.setMoney((double)Integer.valueOf(parts[1]));
            }
        } catch (IOException ex){
            System.out.println("Oops, something went wrong!");
            System.out.println(ex.getMessage());
        }
    return customer;
    }

    @Override
    public void writeCustomer(Customer customer) {
        StringBuilder sb = new StringBuilder();
        sb.append(customer.getName()).append(",")
                .append(customer.getID()).append(",")
                .append(customer.getEmail()).append(",")
                .append(customer.getMoney());

        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FilePaths.CUSTOMER_FILEPATH.getFile(), false))){

                 bufferedWriter.write(sb.toString());

        } catch (IOException ex){
            System.out.println("Oops, something went wrong!");
            System.out.println(ex.getMessage());
        }
    }
}
