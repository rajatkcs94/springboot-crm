package com.project.spring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.project.spring.entity.Customer;


public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomers(int theId);

	public void deleteCustomer(int theId);
	
}
