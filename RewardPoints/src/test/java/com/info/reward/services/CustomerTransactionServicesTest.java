package com.info.reward.services;

import java.awt.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;

import com.info.reward.entities.CustomerTransaction;
import com.info.reward.repository.CustomerTransactionRepository;

public class CustomerTransactionServicesTest {
	CustomerTransactionService c=new CustomerTransactionService();

	@Test
	public void addTransactionTest() {
		CustomerTransaction customerTransaction = Mockito.mock(CustomerTransaction.class);
		CustomerTransactionService customerTransactionService = Mockito.mock(CustomerTransactionService.class);
		CustomerTransactionRepository customerTransactionRepository = Mockito.mock(CustomerTransactionRepository.class);
		Whitebox.setInternalState(customerTransactionService, "transactionRepository", customerTransactionRepository);
		Mockito.doCallRealMethod().when(customerTransactionService).addTransaction(customerTransaction);

		customerTransactionService.addTransaction(customerTransaction);

	}

	@Test
	public void getTransactionByCustomerIdTest() {
		CustomerTransactionService customerTransactionService = Mockito.mock(CustomerTransactionService.class);
		CustomerTransactionRepository customerTransactionRepository = Mockito.mock(CustomerTransactionRepository.class);
		Whitebox.setInternalState(customerTransactionService, "transactionRepository", customerTransactionRepository);
		Mockito.doCallRealMethod().when(customerTransactionService).getTransactionByCustomerId(Mockito.anyLong());

		customerTransactionService.getTransactionByCustomerId(Mockito.anyLong());
	}
	
	@Test
	public void getTransactionByIdTest() {
		CustomerTransactionService customerTransactionService = Mockito.mock(CustomerTransactionService.class);
		CustomerTransactionRepository customerTransactionRepository = Mockito.mock(CustomerTransactionRepository.class);
		Whitebox.setInternalState(customerTransactionService, "transactionRepository", customerTransactionRepository);
		Mockito.doCallRealMethod().when(customerTransactionService).getTransactionById(Mockito.anyLong());

		customerTransactionService.getTransactionById(Mockito.anyLong());
	}
	
	@Test
	public void updateTransactionTest() {
		CustomerTransaction customerTransaction = Mockito.mock(CustomerTransaction.class);
		CustomerTransactionService customerTransactionService = Mockito.mock(CustomerTransactionService.class);
		CustomerTransactionRepository customerTransactionRepository = Mockito.mock(CustomerTransactionRepository.class);
		Whitebox.setInternalState(customerTransactionService, "transactionRepository", customerTransactionRepository);
		Mockito.doCallRealMethod().when(customerTransactionService).updateTransaction(customerTransaction);

		customerTransactionService.updateTransaction(customerTransaction);
	}
	
	@Test
	public void deleteTransactionTest() {
		CustomerTransaction customerTransaction = Mockito.mock(CustomerTransaction.class);
		CustomerTransactionService customerTransactionService = Mockito.mock(CustomerTransactionService.class);
		CustomerTransactionRepository customerTransactionRepository = Mockito.mock(CustomerTransactionRepository.class);
		Whitebox.setInternalState(customerTransactionService, "transactionRepository", customerTransactionRepository);
		Mockito.doCallRealMethod().when(customerTransactionService).deleteTransaction(Mockito.anyLong());
		customerTransactionService.deleteTransaction(Mockito.anyLong());
		Mockito.when(customerTransactionRepository.existsById(Mockito.anyLong())).thenReturn(true);
		customerTransactionService.deleteTransaction(Mockito.anyLong());
	}
	
	
}
