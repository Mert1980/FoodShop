package be.intecbrussel.foodshop.app;

import be.intecbrussel.foodshop.model.Customer;
import be.intecbrussel.foodshop.service.CustomerRepository;

public class FoodShopApp2 {
    public static void main(String[] args) {
        CustomerRepository cr = new CustomerRepository();
        Customer jeanJaque = new Customer("Jean", 12345, "JeanJacqueMetEenC@msn.be", 1000);

        cr.writeCustomer(jeanJaque);
        Customer customer = cr.readCustomer();
        System.out.println(customer);

    }
}
