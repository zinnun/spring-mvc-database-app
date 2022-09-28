package com.oasis.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oasis.springdemo.dao.CustomerDAO;
import com.oasis.springdemo.entity.Customer;
import com.oasis.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	/** // inject the DAO
	@Autowired
	private CustomerDAO customerDAO;
	**/
	
	// injecting customer service instead of customerDAO.
	@Autowired
	private CustomerService customerService;

	//@RequestMapping("/list")
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		
		// get the customers from the !DAO service
		List<Customer> theCustomers = customerService.getCustomers();
		
		// add the customers to the model
		theModel.addAttribute("customers", theCustomers); // adding !dao service to the model
		
		
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		//save the customer
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
	

}
