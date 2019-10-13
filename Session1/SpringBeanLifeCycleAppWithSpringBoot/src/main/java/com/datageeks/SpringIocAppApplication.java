package com.datageeks;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.datageeks.bean.SampleBean;
import com.datageeks.bean.TestBean;

@SpringBootApplication
public class SpringIocAppApplication  implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringIocAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		TestBean s = getTestBean();
			s.getService();
	}

	
	@Bean
	public TestBean getTestBean()
	{
		return new TestBean();
	}
		

}
