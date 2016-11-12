package com.example.darora.greentrack;

/**
 * Created by darora on 11/12/16.
 */

public class Limits {
    public double miscellaneous;
    public double food;
    public double creditCard;
    public double groceries;
    public double coffee;
    public double medical;
    public double clothing;
    public double electronics;
    public double shopping;

    public double cashAtm;

    public Limits(double miscellaneous, double food, double creditCard, double groceries, double coffee,
                  double medical, double clothing, double electronics, double shopping, double cashAtm) {
        this.miscellaneous = miscellaneous;
        this.food = food;
        this.creditCard = creditCard;
        this.groceries = groceries;
        this.coffee = coffee;
        this.medical = medical;
        this.clothing = clothing;
        this.electronics = electronics;
        this.shopping = shopping;
        this.cashAtm = cashAtm;
    }

    public Limits() {

    }

    public double getMiscellaneous() {
        return miscellaneous;
    }

    public double getFood() {
        return food;
    }

    public double getCreditCard() {
        return creditCard;
    }

    public double getGroceries() {
        return groceries;
    }

    public double getCoffee() {
        return coffee;
    }

    public double getMedical() {
        return medical;
    }

    public double getClothing() {
        return clothing;
    }

    public double getElectronics() {
        return electronics;
    }

    public double getShopping() {
        return shopping;
    }

    public double getCashAtm() {
        return cashAtm;
    }
}
