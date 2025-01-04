package com.info.reward;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.info.reward")
public class RewardPointsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RewardPointsApplication.class, args);
	}

}
