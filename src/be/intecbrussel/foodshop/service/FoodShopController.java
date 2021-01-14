package be.intecbrussel.foodshop.service;

import be.intecbrussel.foodshop.model.FoodShop;
import be.intecbrussel.foodshop.model.Stock;

public class FoodShopController {
    private FoodShop KFC = new FoodShop(new Stock());
    private CustomerRepository customerRepository = new CustomerRepository();
    private StockRepository stockRepository = new StockRepository();
}
