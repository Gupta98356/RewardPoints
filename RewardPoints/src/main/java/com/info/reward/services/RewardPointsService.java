package com.info.reward.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.reward.entities.CustomerTransaction;
import com.info.reward.entities.RewardPoints;
import com.info.reward.repository.CustomerTransactionRepository;
import com.info.reward.repository.RewardPiontsRepository;

@Service
public class RewardPointsService {

	@Autowired
	RewardPiontsRepository rewardPiontsRepository;
	
	@Autowired
	CustomerTransactionRepository transactionRepository;
	
	public int calculateRewardPoints(double amount) {
		int points=0;
		if(amount > 100) {
			points += (amount - 100) * 2;
			//amount=100;
		}
		
		if(amount > 50 && amount <100) {
			points += (amount -50);
		}
		
		return points;
	}
	
	public void calculateAndSaveRewardPoints(Long customerId) {
		List<CustomerTransaction> transactions = transactionRepository.findByCustomerId(customerId);
		Map<String, Integer> monthlyPoints=new HashMap<>();
		
		for(CustomerTransaction transaction : transactions) {
			String monthYear = transaction.getDate().getMonthValue() + "-" + transaction.getDate().getYear();
			
			int points=calculateRewardPoints(transaction.getAmount());
			monthlyPoints.put(monthYear, monthlyPoints.getOrDefault(monthYear, 0)+points);
		}
		
		for(Map.Entry<String, Integer> entry : monthlyPoints.entrySet()) {
			String[] parts=entry.getKey().split("-");
			int month=Integer.parseInt(parts[0]);
			int year=Integer.parseInt(parts[1]);
			RewardPoints rewardPoints=new RewardPoints(new RewardPoints().getId(), customerId, month, year, entry.getValue());
			rewardPiontsRepository.save(rewardPoints);
		}
	}
	
	public List<RewardPoints> getRewardPointsByCustomerId(Long customerId){
		return rewardPiontsRepository.findByCustomerId(customerId);
		
	}
	
	public List<RewardPoints> getAllRewardPoints(){
		return rewardPiontsRepository.findAll();
	}
	
}
