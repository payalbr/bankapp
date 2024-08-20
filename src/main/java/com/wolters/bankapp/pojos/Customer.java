package com.wolters.bankapp.pojos;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Customer implements Serializable {

    @Id
    private int accountnum;
    
    private String name;
    private double accountbal;
    private String password;
    
    private String transaction_history = "";

    
    public Customer() {
	}
    
	public int getAccountnum() {
        return accountnum;
    }
    public void setAccountnum(int accountnum) {
        this.accountnum = accountnum;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getAccountbal() {
        return accountbal;
    }
    public void setAccountbal(double accountbal) {
        this.accountbal = accountbal;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getTransactionHistory() {
        return transaction_history;
    }

    public void setTransactionHistory(String transactionHistory) {
        this.transaction_history = transactionHistory;
    }

    public void addTransaction(String transaction) {
        this.transaction_history += transaction + "\n"; // Append new transaction
    }
    
    public Customer(int accountnum, String name, double accountbal, String password) {
        this.accountnum = accountnum;
        this.name = name;
        this.accountbal = accountbal;
        this.password = password;
    }
    @Override
    public String toString() {
        return "Customer [accountnum=" + accountnum + ", name=" + name + ", accountbal=" + accountbal + "]";
    }
    

    

}
