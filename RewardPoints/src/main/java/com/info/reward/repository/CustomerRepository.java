package com.info.reward.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.info.reward.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

	Optional<Customer> findByEmail(String email);
	
}
