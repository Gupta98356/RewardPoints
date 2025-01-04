package com.info.reward.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.info.reward.entities.Customer;
import com.info.reward.services.CustomerService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/register")
	public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer){
		Customer registerCustomer=customerService.registerCustomer(customer);
		return ResponseEntity.ok(registerCustomer);
	}
	
	@PostMapping("login")
	public ResponseEntity<String> login(@RequestBody Map<String, String> loginData){
		Optional<Customer> customer=customerService.findByEmail(loginData.get("email"));
		if(customer.isPresent() && customer.get().getPassword().equals(loginData.get("password"))) {
			return ResponseEntity.ok("Login Successfull");
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credential");
	}

	@PostMapping("/logout")
	public ResponseEntity<String> logout(HttpServletRequest request, HttpServletResponse response){
		
		HttpSession session=request.getSession(false);
		if(session!=null) {
			session.invalidate();
		}
		return ResponseEntity.ok("Logout Successfull");
	}

}
