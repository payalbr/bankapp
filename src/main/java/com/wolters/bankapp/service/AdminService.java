package com.wolters.bankapp.service;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.wolters.bankapp.pojos.Customer;
import com.wolters.bankapp.repository.CustomerRepository;

@Service
public class AdminService {

    @Autowired
    private CustomerRepository cRepo;

    public void addCustomer(Customer customer){
        cRepo.save(customer);
    }
 
    public List<Customer> getAllCustomer() {
        List<Customer> list = cRepo.findAll();
        System.out.println("Fetched Customers: " + list);
        return list;
    }
    
    public void deleteCustomerByAccountnum(int accountnum) {
        if (cRepo.existsById(accountnum)) {
            cRepo.deleteById(accountnum);
            System.out.println("Customer with account number " + accountnum + " deleted.");
        } else {
            System.out.println("Customer with account number " + accountnum + " does not exist.");
        }
    }
    
    public Optional<Customer> getCustomerByAccountnum(int accountnum) {
        return cRepo.findById(accountnum);
    }
    
    
    
    
    public boolean updateCustomerName(int accountnum, String newName) {
        Optional<Customer> customerOpt = cRepo.findById(accountnum);
        if (customerOpt.isPresent()) {
            Customer customer = customerOpt.get();
            customer.setName(newName);
            cRepo.save(customer);
            return true;
        }
        return false;
    }
    

    


}
