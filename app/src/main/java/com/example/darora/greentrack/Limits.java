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

    private double misc; // CHANGE TO MISC
    private double foodDining;
    private double creditCard;
    private double groceries;
    private double coffee;
    private double medical;
    private double clothing;
    private double electronics;
    private double shopping;
    private double cashAtm;

    public Limits() {

    }


    public double getFinancial() {
        return financial;
    }

    public double getUncategorized() {
        return uncategorized;
    }

    public double getFastFood() {
        return fastFood;
    }

    public double getCreditCard() {
        return creditCard;
    }

    public double getRestaurants() {
        return restaurants;
    }

    public double getHomeImprov() {
        return homeImprov;
    }

    public double getCarTaxi() {
        return carTaxi;
    }

    public double getGroceries() {
        return groceries;
    }

    public double getCoffee() {
        return coffee;
    }

    public double getServiceParts() {
        return serviceParts;
    }

    public double getDoctor() {
        return doctor;
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

    public double getPharmacy() {
        return pharmacy;
    }

    public double getFood() {
        return food;
    }

    public double getVacation() {
        return vacation;
    }
}
