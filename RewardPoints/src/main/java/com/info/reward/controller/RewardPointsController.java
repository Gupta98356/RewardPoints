package com.info.reward.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.info.reward.entities.RewardPoints;
import com.info.reward.services.RewardPointsService;

@RestController
public class RewardPointsController {

	@Autowired
	private RewardPointsService rewardPointsService;
	
	@GetMapping("/points")
	public ResponseEntity<List<RewardPoints>> getAllRewardPoints(){
		List<RewardPoints> rewardPoints=rewardPointsService.getAllRewardPoints();
		return ResponseEntity.ok(rewardPoints);
	}
	
	@GetMapping("/points/{customerId}")
	public ResponseEntity<List<RewardPoints>> getRewardPointsByCustomerId(@PathVariable Long customerId){
		List<RewardPoints> rewardPoints=rewardPointsService.getRewardPointsByCustomerId(customerId);
		return ResponseEntity.ok(rewardPoints);
	}
	
}
