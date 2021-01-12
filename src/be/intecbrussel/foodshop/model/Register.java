package be.intecbrussel.foodshop.model;

import be.intecbrussel.foodshop.exception.NotEnoughMoneyInRegisterException;

import java.io.Serializable;

public class Register implements Serializable {
    private double money;

    public Register() {
        this.money = money;
    }

    public double getMoney(){
        return this.money;
    }

    public void addMoney(double moneyToAdd){
        this.money += moneyToAdd;
    }

    public void deductMoney(double moneyToDeduct) throws NotEnoughMoneyInRegisterException {
        if(moneyToDeduct > this.money){
            throw new NotEnoughMoneyInRegisterException(new StringBuilder().append("There is not enough money in the " +
                    "register to proceed this ").append("transaction. Register: " + money + "€ | Trying to deduct: " +
                    "\" + moneyToDeduct + \"€\"").toString());
        }
        this.money -= moneyToDeduct;
    }

}
