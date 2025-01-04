package com.info.reward.services;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;

import com.info.reward.entities.Customer;
import com.info.reward.repository.CustomerRepository;

public class CustomerServiceTest {
	CustomerService cs=new CustomerService();

	@Test
	public void addTransactionTest() {
		Customer customer = Mockito.mock(Customer.class);
		CustomerService customerService = Mockito.mock(CustomerService.class);
		CustomerRepository customerRepository = Mockito.mock(CustomerRepository.class);
		Whitebox.setInternalState(customerService, "customerRepository", customerRepository);
		Mockito.doCallRealMethod().when(customerService).registerCustomer(customer);

		customerService.registerCustomer(customer);
		
		Mockito.doCallRealMethod().when(customerService).findByEmail(Mockito.anyString());

		customerService.findByEmail(Mockito.anyString());

	}
}
