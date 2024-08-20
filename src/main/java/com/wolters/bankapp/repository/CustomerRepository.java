
 package com.wolters.bankapp.repository;
  
 import org.springframework.data.jpa.repository.JpaRepository;
  
 import com.wolters.bankapp.pojos.Customer;
  
 public interface CustomerRepository extends JpaRepository<Customer, Integer>{
  
  
 }
 