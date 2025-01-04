package com.info.reward.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.reward.entities.Customer;
import com.info.reward.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer registerCustomer(Customer customer) {
		return customerRepository.save(customer);
		
	}
	
	public Optional<Customer> findByEmail(String email){
		return customerRepository.findByEmail(email);
	}
}
