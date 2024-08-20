package com.wolters.bankapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wolters.bankapp.pojos.Customer;

import com.wolters.bankapp.service.AdminService;
//import com.wolters.bankapp.service.CustomerService;

@Controller
public class AdminController {

	@Autowired
	private AdminService as;

	@GetMapping("/")
	public String home() {
		return "home.jsp";
	}

	@RequestMapping("/adminlogin")
	public ModelAndView adminLoginActivity(String username, String password) {
		String adminname = "Payal";
		ModelAndView mv = new ModelAndView();
		if (username.equalsIgnoreCase(adminname) && password.equalsIgnoreCase(adminname)) {
			mv.setViewName("adminactions.jsp");
		} else {
			mv.setViewName("adminlogin.jsp");
		}
		return mv;
	}

	@RequestMapping("/addcustomer")
	public ModelAndView addCustomer(Customer customer) {
		as.addCustomer(customer);
		//System.out.println("added");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("view.jsp");
		mv.addObject("customer", customer);
		return mv;
	}
	
	@RequestMapping("/showcust")
	public ModelAndView showCustomer(Customer customer) {
		System.out.println("shown cust");
		ModelAndView mv=new ModelAndView("showcust.jsp");
	      
		List<Customer> list=as.getAllCustomer();
        //mv.addObject("customer",customer);
		mv.addObject("customer", list);
        return mv;
	}
	
	@RequestMapping("/delete")
	public String deleteCustomer(@RequestParam("accountnum") int accountnum) {
	    as.deleteCustomerByAccountnum(accountnum);
	    return "redirect:/showcust"; // Redirect to show updated customer list or another confirmation page
	}
	
	@RequestMapping("/search")
    public ModelAndView searchCustomer(@RequestParam("accountnum") int accountnum) {
        Optional<Customer> customerOpt = as.getCustomerByAccountnum(accountnum);
        ModelAndView mv = new ModelAndView("searchresult.jsp");
        
        if (customerOpt.isPresent()) {
            mv.addObject("customer", customerOpt.get());
        } else {
            mv.addObject("message", "Customer with account number " + accountnum + " not found.");
        }
        return mv;
    }

	@RequestMapping("/update")
	public ModelAndView showUpdateForm(@RequestParam("accountnum") int accountnum
			
			) {
		
	    Optional<Customer> customerOpt = as.getCustomerByAccountnum(accountnum);
//	     as.updateCustomerName( accountnum,  upname);
	    ModelAndView mv = new ModelAndView("updatename.jsp");

	    if (customerOpt.isPresent()) {
	        mv.addObject("customer", customerOpt.get());
	    } else {
	        mv.addObject("message", "Customer with account number " + accountnum + " not found.");
	    }
	    return mv;
	}
	
	
	
	@RequestMapping("/makeup")
	public ModelAndView makeup(@RequestParam("accountnum") int accountnum,
			@RequestParam("newName") String upname
			) {
		
	    Optional<Customer> customerOpt = as.getCustomerByAccountnum(accountnum);
	  boolean b=   as.updateCustomerName( accountnum,  upname);
	  
	  ModelAndView mv = new ModelAndView("try.jsp");
	    if (b==true) {
	        mv.addObject("cust", as.getCustomerByAccountnum(accountnum));
	    } else {
	        mv.addObject("cust", "Customer with account number " + accountnum + " not found.");
	    }
	    return mv;
	}

	



}
