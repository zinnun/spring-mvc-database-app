package com.oasis.springdemo.dao;

import java.util.List;

import com.oasis.springdemo.entity.Customer;

public interface CustomerDAO {

	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);
	
}
