package com.wolters.bankapp.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolters.bankapp.pojos.Customer;
import com.wolters.bankapp.repository.CustomerRepository;

@Service
public class CustomerService {
	
	 @Autowired
	 private CustomerRepository cRepo;
	
	 public Optional<Customer> getCustomerByAccountnum(int accountnum) {
	        return cRepo.findById(accountnum);
	    }
	 public void updateCustomer(Customer customer) {
	        cRepo.save(customer);
	    }

	 public boolean depositMoney(int accountnum, double amount) {
		    Optional<Customer> customerOpt = getCustomerByAccountnum(accountnum);
		    if (customerOpt.isPresent()) {
		        Customer customer = customerOpt.get();
		        if (amount > 0) {
		            customer.setAccountbal(customer.getAccountbal() + amount);
		            customer.addTransaction("Deposit: " + amount + " on " + LocalDate.now()); // Add transaction
		            updateCustomer(customer);
		            return true;
		        }
		    }
		    return false;
		}

		public boolean withdrawMoney(int accountnum, double amount) {
		    Optional<Customer> customerOpt = getCustomerByAccountnum(accountnum);
		    if (customerOpt.isPresent()) {
		        Customer customer = customerOpt.get();
		        if (amount > 0 && customer.getAccountbal() >= amount) {
		            customer.setAccountbal(customer.getAccountbal() - amount);
		            customer.addTransaction("Withdrawal: " + amount + " on " + LocalDate.now()); // Add transaction
		            updateCustomer(customer);
		            return true;
		        }
		    }
		    return false;
		}

		public boolean transferMoney(int fromAccountnum, int toAccountnum, double amount) {
		    Optional<Customer> fromCustomerOpt = getCustomerByAccountnum(fromAccountnum);
		    Optional<Customer> toCustomerOpt = getCustomerByAccountnum(toAccountnum);

		    if (fromCustomerOpt.isPresent() && toCustomerOpt.isPresent()) {
		        Customer fromCustomer = fromCustomerOpt.get();
		        Customer toCustomer = toCustomerOpt.get();

		        if (amount > 0 && fromCustomer.getAccountbal() >= amount) {
		            fromCustomer.setAccountbal(fromCustomer.getAccountbal() - amount);
		            toCustomer.setAccountbal(toCustomer.getAccountbal() + amount);
		            
		            fromCustomer.addTransaction("Transfer: " + amount + " to account " + toAccountnum + " on " + LocalDate.now()); // Add transaction
		            toCustomer.addTransaction("Transfer: " + amount + " from account " + fromAccountnum + " on " + LocalDate.now()); // Add transaction

		            updateCustomer(fromCustomer);
		            updateCustomer(toCustomer);
		            return true;
		        }
		    }
		    return false;
		}

	 public List<String> getMiniStatement(int accountnum) {
		    Optional<Customer> customerOpt = getCustomerByAccountnum(accountnum);
		    List<String> transactions = new ArrayList<>();

		    if (customerOpt.isPresent()) {
		        Customer customer = customerOpt.get();
		        String transaction_history = customer.getTransactionHistory();

		        // Print or log transaction history
		        System.out.println("Retrieved Transaction History: " + transaction_history);

		        if (transaction_history != null && !transaction_history.isEmpty()) {
		            String[] transactionArray = transaction_history.split("\n");
		            for (String transaction : transactionArray) {
		                transactions.add(transaction);
		            }
		        }
		    } else {
		        System.out.println("No customer found with account number: " + accountnum);
		    }

		    return transactions;
		}
	 public boolean changeCustomerPassword(int accountnum, String currentPassword, String newPassword) {
	        Optional<Customer> customerOpt = cRepo.findById(accountnum);
	        
	        if (customerOpt.isPresent()) {
	            Customer customer = customerOpt.get();
	            if (customer.getPassword().equals(currentPassword)) {
	                customer.setPassword(newPassword);
	                cRepo.save(customer); 
	                return true; 
	            } else {
	                return false; 
	            }
	        } else {
	            return false; 
	        }
	    }

}
