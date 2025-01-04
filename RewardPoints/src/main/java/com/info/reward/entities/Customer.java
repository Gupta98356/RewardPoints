package com.info.reward.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Customer {

	@Id
	private Long id;
	
	private String name;
	
	private String email;
	
	private String password;
	
	
}
