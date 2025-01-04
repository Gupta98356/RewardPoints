package com.info.reward.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.reward.entities.CustomerTransaction;
import com.info.reward.repository.CustomerTransactionRepository;

@Service
public class CustomerTransactionService {

	@Autowired
	CustomerTransactionRepository transactionRepository;
	
	public CustomerTransaction addTransaction(CustomerTransaction transaction) {
		return transactionRepository.save(transaction);
	}
	
	public List<CustomerTransaction> getTransactionByCustomerId(Long CustomerId){
		return transactionRepository.findByCustomerId(CustomerId);
	}
	
	public Optional<CustomerTransaction> getTransactionById(Long id){
		return transactionRepository.findById(id);
	}
	
	public CustomerTransaction updateTransaction(CustomerTransaction transaction) {
		return transactionRepository.save(transaction);
	}
	
	public boolean deleteTransaction(Long id) {
		if(transactionRepository.existsById(id)) {
			transactionRepository.deleteById(id);
			return true;
		}else{
			return false;
		}
	}
}
