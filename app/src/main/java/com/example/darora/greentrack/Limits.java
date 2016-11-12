package com.example.darora.greentrack;

/**
 * Created by darora on 11/12/16.
 */

public class Limits {
    //    Financial - DELETE - DONE
    //
    //    Home improvement - DELETE
    //    Rental Car & Taxi - DELETE
    //    Service & Parts - DELETE
    //            Vacation - DELETE
    //    Check - DELETE

//    Uncategorized - CHANGE MISC

//    Credit Card payment
//            Groceries
//    Coffee Shops
//            Clothing
//    Electronics & Software
//            Shopping
//    Cash & ATM

//    Pharmacy - CHANGE TO MEDICAL
//    Doctor - CHANGE TO MEDICAL

//    Food & Dining - Fast food + food & dining + restaurants
            //  Restaurants - CHANGE TO FOOD
            //    Fast Food - CHANGE TO FOOD

    private double misc;
    private double foodDining;
    private double creditCard;
    private double groceries;
    private double coffee;
    private double medical;
    private double clothing;
    private double electronics;
    private double shopping;
    private double cashAtm;

    public Limits(double misc, double foodDining, double creditCard, double groceries, double coffee,
                  double medical, double clothing, double electronics, double shopping, double cashAtm) {
        this.misc = misc;
        this.foodDining = foodDining;
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

    public double getCashAtm() {
        return cashAtm;
    }

    public double getMisc() {
        return misc;
    }

    public double getFoodDining() {
        return foodDining;
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
}
