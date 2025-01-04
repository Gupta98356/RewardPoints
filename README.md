# RewardPoints
This is a Reward Points System implemented using Spring Boot framework that provides features like customer registration, login, transaction management, and reward points calculation. The system supports customers registering, logging in, performing transactions, and accumulating reward points based on their transaction amounts.

## Table of Contents
Introduction
Features
Technology Stack
API Endpoints
Setup and Installation

## Introduction
This project is designed to manage customer data, their transactions, and reward points. The system calculates reward points based on the transaction amount and provides API endpoints for customer management and transaction history.

## Features
Customer Registration: Allows users to register by providing their details (name, email, password).
Customer Login: Users can log in by providing email and password. On successful login, a success message is returned.
Customer Logout: Users can log out by invalidating their session.
Add Transactions: Customers can perform transactions, and based on the transaction amount, reward points will be calculated and stored.
Update Transactions: Customers can update transaction details.
Delete Transactions: Customers can delete their transaction entries.
View Reward Points: Reward points can be viewed for a specific customer, or all customers can view their points.

# Technology Stack
Backend: Spring Boot
Database: MySQL (or any other relational DB)
Libraries:
Spring Data JPA
Spring Web
Spring mysql-connector-j
Java Version: Java 17 or above

# Configuration
spring.application.name=RewardPoints
spring.datasource.url=jdbc:mysql://localhost:3306/reward_db
spring.datasource.username=YourUsername
spring.datasource.password=YourPassword
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.ddl-auto=update

# Usage
Running the Application
Once the application is running, you can interact with it using any HTTP client like Postman.

Example Request
Register a new customer: "http://localhost:8080/register" with Customer Object through Postman.

## API Endpoints
# Customer Controller
POST /register - Register a new customer.

POST /login - Login a customer.

POST /logout - Logout a customer.

# Customer Transaction Controller
POST /addTransaction - Add a new transaction for a customer.

GET /getAllTransaction/{customerId} - Get all transactions for a customer.

PUT /update/{id} - Update a transaction.

DELETE /delete/{id} - Delete a transaction.

# Reward Points Controller
GET /points - Get all reward points.

GET /points/{customerId} - Get reward points for a specific customer.

# Installation
# 1 **Clone the repository:**
  ```bash git clone https://github.com/yourusername/reward-points-system.git
# 2 Navigate to the project directory:
  cd reward-points-system
# Build the project:
  mvn clean install
# Run the application:
  mvn spring-boot:run
