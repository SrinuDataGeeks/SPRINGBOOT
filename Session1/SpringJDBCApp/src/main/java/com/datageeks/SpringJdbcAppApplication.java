package com.datageeks;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.datageeks.dao.EmployeeBean;
import com.datageeks.service.EmployeeService;

@SpringBootApplication
public class SpringJdbcAppApplication  implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		EmployeeService service = getEmployeeService();
		
		//service.save(new EmployeeBean(222, "Kiran", 15000f));
		
		List<EmployeeBean> empList = service.getAll();
		System.out.println(" \n\n *****Employee Details *****");
		
		for(EmployeeBean emp : empList)
		{
			System.out.println(emp);
		}
		System.out.println("\n\n");
		
		System.out.println("\n\n 111 Employee Info ");
		System.out.println(service.getById(111)+"\n");
		
		
	}
	
	@Bean
	public EmployeeService getEmployeeService()
	{
		return new EmployeeService();
	}
	

}
