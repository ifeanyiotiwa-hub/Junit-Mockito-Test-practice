package dev.betpawa.practice;

import java.text.NumberFormat;

public class Account {

    private final NumberFormat fmt = NumberFormat.getCurrencyInstance();

    private final long acctNumber;
    private float balance;
    private final String name;


    public Account(String owner, long acctNumber, float initial) {
        this.name = owner;
        this.balance = initial;
        this.acctNumber = acctNumber;
    }

    public boolean deposit(float amount) {
        boolean result = true;

        if (amount < 0) {
            return false;
        } else {
            balance = balance + amount;
        }
        return result;
    }


    public boolean withdraw(float amount, float fee) {
        if (isValidWithdrawal(amount, fee)) {
            amount += fee;
            balance = balance - amount;
        }
        return isValidWithdrawal(amount, fee);
    }

    private boolean isValidWithdrawal(float amount, float fee) {
        return amount >= 0 && fee >= 0 && amount <= balance - amount;
    }

    public void addInterest() {
        //4.5% interest rate;
        float k_INTEREST_RATE = 0.045f;
        balance += balance * k_INTEREST_RATE;
    }

    public long getAcctNumber() {
        return acctNumber;
    }

    public float getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Account{" + acctNumber + "\t" + name + "\t" + fmt.format(balance) + "}";
    }
}
