package be.intecbrussel.foodshop.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FoodShop {
    private List<Register> registers;
    private Stock stock;
    private CustomerRepository customerRepository;

    public FoodShop() {
        this.registers = new ArrayList<>();
    }

    public List<Register> getRegisters() {
        return registers;
    }

    public void setRegisters(List<Register> registers) {
        this.registers = registers;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public CustomerRepository getCustomerRepository() {
        return customerRepository;
    }

    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Map<Food, Integer> sellFood(Order order, Customer payingCustomer){
        // remove order from stock
        order.getFoodItems()
                .forEach((food, amount) -> stock.removeFromStock(food, amount));

        // calculate the total order price
        double totalPrice = order.getTotalPrice();

        // update the money of customer
        double moneyInHand = payingCustomer.getMoney() - totalPrice;
        payingCustomer.setMoney(moneyInHand);

        // add money to register (In which register will I add money ???


        return order.getFoodItems();
    }
}
