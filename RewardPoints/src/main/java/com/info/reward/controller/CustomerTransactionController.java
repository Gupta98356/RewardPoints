package com.info.reward.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.info.reward.entities.CustomerTransaction;
import com.info.reward.services.CustomerTransactionService;
import com.info.reward.services.RewardPointsService;

@RestController
public class CustomerTransactionController {

	@Autowired
	CustomerTransactionService transactionService;
	
	@Autowired
	private RewardPointsService rewardPointsService;
	
	@PostMapping("/addTransaction")
	public ResponseEntity<CustomerTransaction> addTransaction(@RequestBody CustomerTransaction transaction){
		CustomerTransaction saveTransaction=transactionService.addTransaction(transaction);
		rewardPointsService.calculateAndSaveRewardPoints(saveTransaction.getCustomerId());
		return ResponseEntity.ok(saveTransaction);
	}
	
	@GetMapping("/getAllTransaction/{customerId}")
	public ResponseEntity<List<CustomerTransaction>> getTransactionByCustomerId(@PathVariable Long customerId){
		List<CustomerTransaction> transaction=transactionService.getTransactionByCustomerId(customerId);
		return ResponseEntity.ok(transaction);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<CustomerTransaction> updateTransaction(@PathVariable Long id, @RequestBody CustomerTransaction customerDetail){
		
		Optional<CustomerTransaction> optionalTransaction = transactionService.getTransactionById(id);
		if(optionalTransaction.isPresent()) {
			CustomerTransaction transaction=optionalTransaction.get();
			transaction.setAmount(customerDetail.getAmount());
			transaction.setDate(customerDetail.getDate());
			CustomerTransaction updateTransaction=transactionService.updateTransaction(transaction);
			return ResponseEntity.ok(updateTransaction);
			
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteTransaction(@PathVariable Long id){
		boolean isDesable=transactionService.deleteTransaction(id);
		if(isDesable) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}
