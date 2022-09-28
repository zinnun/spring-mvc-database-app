package com.oasis.springdemo.service;

import java.util.List;

import com.oasis.springdemo.entity.Customer;

public interface CustomerService {

	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);
}
