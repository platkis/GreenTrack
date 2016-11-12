package com.example.darora.greentrack;

/**
 * Created by darora on 11/12/16.
 */

public class Transaction {
    private boolean pending;
    private String currency;
    private double id;
    private double amount;
    private double accountId;
    private String isBankCc;
    private String category;
    private String date;
    private String name;

    public Transaction() {

    }

    public boolean isPending() {
        return pending;
    }

    public String getCurrency() {
        return currency;
    }

    public double getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public double getAccountId() {
        return accountId;
    }

    public String getIsBankCc() {
        return isBankCc;
    }

    public String getCategory() {
        return category;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }
}
