package com.mycompany.foodwaste_project.domain;

public class monetarySystem {
    public double balance;
    
    public monetarySystem() {
        balance = 900;
    }
    
    public void Buy (double price) { 
        balance = balance-price;
    }
        
    public double getBalance() {
        return balance;
    }
    
    public void setBalance(double amount)
    {
        balance += amount;
    }
    
}
