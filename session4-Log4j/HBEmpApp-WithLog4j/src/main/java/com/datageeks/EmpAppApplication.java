package com.datageeks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmpAppApplication {
static Logger log = LoggerFactory.getLogger(EmpAppApplication.class);
	public static void main(String[] args) {
		log.debug("EmpAppApplication main(..) started" );
		SpringApplication.run(EmpAppApplication.class, args);
		log.debug("EmpAppApplication main(...) completed" );

	}

}
