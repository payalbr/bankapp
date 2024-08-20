package com.wolters.bankapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wolters.bankapp.pojos.Customer;
import com.wolters.bankapp.service.CustomerService;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService cs;
    
    @GetMapping("/custlogin")
    public ModelAndView showLoginForm() {
        return new ModelAndView("custlogin");
    }

    @PostMapping("/custlogin")
    public ModelAndView handleLoginOrSetup(@RequestParam("accountnum") int accountnum, 
                                           @RequestParam("password") String password) {
        ModelAndView mv = new ModelAndView();
        Optional<Customer> customerOpt = cs.getCustomerByAccountnum(accountnum);

        if (customerOpt.isPresent()) {
            Customer customer = customerOpt.get();
            
            if (customer.getPassword() == null) {
                customer.setPassword(password);
                cs.updateCustomer(customer);
                mv.setViewName("custlogin.jsp");
                mv.addObject("message", "Password set successfully. Please log in.");
                return new ModelAndView("redirect:/custlogin.jsp");
            } else {
               
                if (customer.getPassword().equals(password)) {
                    mv.setViewName("redirect:/custactions.jsp");  // Redirect to custactions page
                    return mv;
                } else {
                    mv.setViewName("custlogin.jsp");
                    mv.addObject("errorMessage", "Invalid password.");
                    return mv;
                }
            }
        } else {
            mv.setViewName("custlogin.jsp");
            mv.addObject("errorMessage", "Customer with account number " + accountnum + " not found.");
            return mv;
        }
    }

    @GetMapping("/deposit")
    public ModelAndView showDepositForm() {
        return new ModelAndView("deposit.jsp");
    }
    @PostMapping("/deposit")
    public ModelAndView handleDeposit(@RequestParam("accountnum") int accountnum,
                                      @RequestParam("amount") double amount) {
        ModelAndView mv = new ModelAndView();
        boolean success = cs.depositMoney(accountnum, amount);

        if (success) {
          
            Optional<Customer> customerOpt = cs.getCustomerByAccountnum(accountnum);
            if (customerOpt.isPresent()) {
                Customer customer = customerOpt.get();
                mv.addObject("customer", customer);
                mv.setViewName("deposit.jsp");
                mv.addObject("errorMessage", "Deposit successful");
                mv.setViewName("custdetails.jsp"); 
            }
        } else {
            mv.setViewName("deposit.jsp");
            mv.addObject("errorMessage", "Deposit failed. Please check the account number and amount.");
        }
        return mv;
    }
    @GetMapping("/withdraw")
    public ModelAndView showWithdrawForm() {
        return new ModelAndView("withdraw.jsp");
    }
    
    @PostMapping("/withdraw")
    public ModelAndView handleWithdraw(@RequestParam("accountnum") int accountnum,
                                       @RequestParam("amount") double amount) {
        ModelAndView mv = new ModelAndView();
        boolean success = cs.withdrawMoney(accountnum, amount);

        if (success) {
            Optional<Customer> customerOpt = cs.getCustomerByAccountnum(accountnum);
            if (customerOpt.isPresent()) {
                Customer customer = customerOpt.get();
                mv.addObject("customer", customer);
                mv.addObject("errorMessage", "Withdrawal successful");
                mv.setViewName("custdetails.jsp");
            }
        } else {
            mv.setViewName("withdraw.jsp");
            mv.addObject("errorMessage", "Withdrawal failed. Please check the account number and amount.");
        }
        return mv;
    }
  
    @GetMapping("/transfer")
    public ModelAndView showTransferForm() {
        return new ModelAndView("transfer.jsp");
    }
    @PostMapping("/transfer")
    public ModelAndView handleTransfer(@RequestParam("fromAccountnum") int fromAccountnum,
                                       @RequestParam("toAccountnum") int toAccountnum,
                                       @RequestParam("amount") double amount) {
        ModelAndView mv = new ModelAndView();
        boolean success = cs.transferMoney(fromAccountnum, toAccountnum, amount);

        if (success) {
            mv.setViewName("transferdetails.jsp");
   
            Customer fromCustomer = cs.getCustomerByAccountnum(fromAccountnum).orElse(null);
            Customer toCustomer = cs.getCustomerByAccountnum(toAccountnum).orElse(null);

            mv.addObject("fromCustomer", fromCustomer);
            mv.addObject("toCustomer", toCustomer);
            mv.addObject("message", "Transfer successful.");
        } else {
            mv.setViewName("transfer.jsp");
            mv.addObject("errorMessage", "Transfer failed. Please check account numbers and balance.");
        }
        return mv;
    }
    
    @GetMapping("/checkbalance")
    public ModelAndView showBalanceForm() {
        return new ModelAndView("checkbal.jsp");
    }
    
    @PostMapping("/checkbalance")
    public ModelAndView handleCheckBalance(@RequestParam("accountnum") int accountnum) {
        ModelAndView mv = new ModelAndView();
        Optional<Customer> customerOpt = cs.getCustomerByAccountnum(accountnum);

        if (customerOpt.isPresent()) {
            Customer customer = customerOpt.get();
            mv.addObject("customer", customer);
            mv.setViewName("baldetails.jsp");
        } else {
            mv.setViewName("checkbal.jsp");
            mv.addObject("errorMessage", "Customer with account number " + accountnum + " not found.");
        }
        return mv;
    }
    @GetMapping("/ministatement")
    public ModelAndView getMiniStatement(@RequestParam("accountnum") int accountnum) {
        ModelAndView mv = new ModelAndView();

        Optional<Customer> customerOpt = cs.getCustomerByAccountnum(accountnum);
        if (customerOpt.isPresent()) {
            Customer customer = customerOpt.get();
            List<String> transactions = cs.getMiniStatement(accountnum);

            mv.setViewName("ministat.jsp");
            mv.addObject("customer", customer);
            mv.addObject("transactions", transactions);
        } else {
            mv.setViewName("ministat.jsp");
            mv.addObject("errorMessage", "Customer with account number " + accountnum + " not found.");
        }
        return mv;
    }
    @RequestMapping("/changepass")
    public ModelAndView changePassword(@RequestParam("accountnum") int accountnum,
                                        @RequestParam("currentPassword") String currentPassword,
                                        @RequestParam("newPassword") String newPassword) {
        boolean result = cs.changeCustomerPassword(accountnum, currentPassword, newPassword);
        ModelAndView mv = new ModelAndView("changepass.jsp");

        if (result) {
            mv.addObject("message", "Password changed successfully.");
        } else {
            mv.addObject("message", "Failed to change password. Current password might be incorrect or customer not found.");
        }

        return mv;
    }



}
