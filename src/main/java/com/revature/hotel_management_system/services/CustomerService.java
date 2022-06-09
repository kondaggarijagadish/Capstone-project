package com.revature.hotel_management_system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.hotel_management_system.model.Customer;
import com.revature.hotel_management_system.repo.CustomerRepo;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepo customerRepo;
	
	public List<Customer> showAllCustomers(){
		List<Customer> customers=(List<Customer>) customerRepo.findAll();
		return customers;
	}
	
	public Customer getCustomerProfile(String emailId) {
		Customer customer=customerRepo.findById(emailId).orElse(null);
		return customer;
	}

	public Customer updateCustomerProfile(String userName, long mobileNumber, String userEmail, String address) {
		Customer customer=customerRepo.findById(userEmail).orElse(null);
		customer.setUserName(userName);
		//customerRepo.save(customer);
		customer.setMobileNumber(mobileNumber);
		//customerRepo.save(customer);
		customer.setAddress(address);
		customerRepo.save(customer);
		//Customer updatedCustomer=customerRepo.findById(userEmail).orElse(null);
		return customer;
	}

}
