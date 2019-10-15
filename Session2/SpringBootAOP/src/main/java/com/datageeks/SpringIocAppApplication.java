package com.datageeks;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.datageeks.service.AccountService;

@SpringBootApplication
public class SpringIocAppApplication  implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringIocAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		AccountService service = geAccountService();
		service.getInfo();
	}
	
	
	@Bean
	public AccountService geAccountService()
	{
		return new AccountService();
	}

}
