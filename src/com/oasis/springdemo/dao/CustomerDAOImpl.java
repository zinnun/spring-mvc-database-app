package com.oasis.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.oasis.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	// need to inject the session factory, so DAO can use it to talking to database
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	//@Transactional		// import org.springframework.transaction.annotation.Transactional;
	public List<Customer> getCustomers() {
		
		// get the current hibernate session
		Session currentSession= sessionFactory.getCurrentSession();
		
		
		// create a query ... sort by first name
		Query<Customer> theQuery=
				currentSession.createQuery("from Customer order by firstName", Customer.class);	// org.hibernate.query.Query -> v5.2
		
		// execute the query
		List<Customer> customers = theQuery.getResultList();
		
		
		// return the result
		return customers;
	}


	@Override
	public void saveCustomer(Customer theCustomer) {

		// get the current hibernate session
		Session currentSession= sessionFactory.getCurrentSession();
				
		// save the customer
		currentSession.save(theCustomer);
	}

}
