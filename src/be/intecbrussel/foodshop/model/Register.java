package be.intecbrussel.foodshop.model;

public class Register {
    private double money;

    public Register(double money) {
        this.money = money;
    }

    public double getMoney(){
        return this.money;
    }

    public void addMoney(double moneyToAdd){
        this.money += moneyToAdd;
    }

    public void deductMoney(double moneyToDeduct){
        this.money -= moneyToDeduct;
    }

}
