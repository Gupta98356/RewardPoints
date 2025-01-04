package com.info.reward.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.info.reward.entities.RewardPoints;

public interface RewardPiontsRepository extends JpaRepository<RewardPoints, Long>{

	List<RewardPoints> findByCustomerId(Long customerId);
}
