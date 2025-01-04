package com.info.reward.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.info.reward.entities.CustomerTransaction;

public interface CustomerTransactionRepository extends JpaRepository<CustomerTransaction, Long>{

	List<CustomerTransaction> findByCustomerId(Long customerId);
}
