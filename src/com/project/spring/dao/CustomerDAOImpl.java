package com.project.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.spring.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
	
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create Query (HQL)
		Query<Customer> theQuery = 
						currentSession.createQuery("from Customer order by lastName	", Customer.class);
		
		// execute the Query and get result list
		List<Customer> customers = theQuery.getResultList();
		
		// return the list
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save the customer
		//currentSession.save(theCustomer);
		
		// save or update the customer after adding update feature
		currentSession.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer getCustomers(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from the database using the primary key
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete the customer from database using primary key using HQL query
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		
		// set query Parameter
		theQuery.setParameter("customerId", theId);
		
		// execute the query
		theQuery.executeUpdate();
		
	}

}





