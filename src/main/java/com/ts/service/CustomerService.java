package com.ts.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ts.dao.CustomerDao;
import com.ts.Exception.CustomerUpdateException;
import com.ts.Exception.ResourceNotFoundException;
import com.ts.model.Customer;

import java.util.List;

	@Service
	public class CustomerService {

	    @Autowired
	    private CustomerDao customerDao;

	    public List<Customer> getAllCustomers() {
	        return customerDao.findAll();
	    }

	    public Customer getCustomerById(Long id) {
	        return customerDao.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Customer not found with ID: " + id));
	    }
	    public List<Customer> getCustomersByName(String name) {
	        return customerDao.findByName(name);
	    }

	    public Customer getCustomerByEmail(String email) {
	        return customerDao.findByEmail(email);
	    }

	    public List<Customer> getCustomersByNoOfPeopleGreaterThan(int no_of_People) {
	        return customerDao.findByNoOfPeopleGreaterThan(no_of_People);
	        
	    }
	   

	    public void addCustomer(Customer customer) {
	        customerDao.save(customer);
	    }

	    public void updateCustomer(Customer customer) {
	        if (customerDao.existsById(customer.getId())) {
	            customerDao.save(customer);
	        }
	        {
	            throw new CustomerUpdateException("Unable to update. Customer not found with ID: " + customer.getId());
	        }
	  
	    }

	    public void deleteCustomer(Long id) {
	        customerDao.deleteById(id);
	    }

	    
	}
