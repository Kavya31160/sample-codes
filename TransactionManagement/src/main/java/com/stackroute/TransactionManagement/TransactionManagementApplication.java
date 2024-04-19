package com.stackroute.TransactionManagement;

import com.stackroute.TransactionManagement.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.stackroute.TransactionManagement.model.User;
@SpringBootApplication
public class TransactionManagementApplication implements CommandLineRunner{

	private final UserService userService;

	public TransactionManagementApplication(UserService userService) {
		this.userService = userService;
	}
	public static void main(String[] args) {
		SpringApplication.run(TransactionManagementApplication.class, args);
	}

	@Override
	public void run(String... args) {
		// Save some sample data
		User user1 = new User();
		user1.setFirstName("John");
		user1.setLastName("Doe");
		user1.setAge(30);

		userService.saveUser(user1);

		// Retrieve and print the user
		User retrievedUser = userService.getUserById(user1.getId());
		System.out.println("Retrieved user: " + retrievedUser.getFirstName());

		// Delete the user by first name within a transaction
		userService.deleteUserByFirstName("John");

		// Attempt to retrieve the user after deletion
		retrievedUser = userService.getUserById(user1.getId());
		System.out.println("Retrieved user after deletion: " + retrievedUser);
	}
}
