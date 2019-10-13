package com.datageeks;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.datageeks.controller.AccountController;

@SpringBootApplication
public class SpringIocAppApplication  implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringIocAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		AccountController controller = getAccountController();
		controller.getInfo();
	}
	
	
	@Bean
	public AccountController getAccountController()
	{
		return new AccountController();
	}

}
