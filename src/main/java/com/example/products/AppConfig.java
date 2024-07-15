package com.example.products;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	 @Bean
	    public EmployeeServiceImpl employeeService(EmployeeRepositary employeeRepository) {
	        return new EmployeeServiceImpl(employeeRepository);
	    }

}
