package com.info.reward.services;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;

import com.info.reward.entities.CustomerTransaction;
import com.info.reward.repository.CustomerTransactionRepository;
import com.info.reward.repository.RewardPiontsRepository;

public class RewardPointsServiceTest {

	@Test
	public void calculateRewardPointsTest() {
		RewardPointsService rewardPointsService=new RewardPointsService();
		rewardPointsService.calculateRewardPoints(101);
		rewardPointsService.calculateRewardPoints(60);
		rewardPointsService.calculateRewardPoints(10);
	}
	
	@Test
	public void addTransactionTest() {
		RewardPointsService rewardPointsService = Mockito.mock(RewardPointsService.class);
		CustomerTransactionRepository customerTransactionRepository = Mockito.mock(CustomerTransactionRepository.class);
		Whitebox.setInternalState(rewardPointsService, "transactionRepository", customerTransactionRepository);
		RewardPiontsRepository rewardPiontsRepository = Mockito.mock(RewardPiontsRepository.class);
		Whitebox.setInternalState(rewardPointsService, "rewardPiontsRepository", rewardPiontsRepository);
		CustomerTransaction customerTransaction=new CustomerTransaction();
		customerTransaction.setAmount(100);
		customerTransaction.setCustomerId(121l);
		customerTransaction.setDate(LocalDate.parse("2025-01-01"));
		customerTransaction.setId(1l);
		List<CustomerTransaction> transactions =new ArrayList<>();
		transactions.add(customerTransaction);
		
		Mockito.when(customerTransactionRepository.findByCustomerId(100l)).thenReturn(transactions);
		
		Mockito.doCallRealMethod().when(rewardPointsService).calculateAndSaveRewardPoints(100l);

		rewardPointsService.calculateAndSaveRewardPoints(100l);

	}
	
	@Test
	public void getRewardPointsByCustomerIdtest() {
		RewardPointsService rewardPointsService = Mockito.mock(RewardPointsService.class);

		RewardPiontsRepository rewardPiontsRepository = Mockito.mock(RewardPiontsRepository.class);
		Whitebox.setInternalState(rewardPointsService, "rewardPiontsRepository", rewardPiontsRepository);
		
		
		Mockito.doCallRealMethod().when(rewardPointsService).getRewardPointsByCustomerId(100l);

		rewardPointsService.getRewardPointsByCustomerId(100l);
		Mockito.doCallRealMethod().when(rewardPointsService).getAllRewardPoints();

		rewardPointsService.getAllRewardPoints();
	}
}
