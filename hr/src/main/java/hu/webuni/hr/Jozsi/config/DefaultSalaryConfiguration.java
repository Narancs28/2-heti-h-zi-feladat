package hu.webuni.hr.Jozsi.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import hu.webuni.hr.Jozsi.service.DefaultEmployeeService;
import hu.webuni.hr.Jozsi.service.EmployeeService;

@Configuration
@Profile("!smart")
public class DefaultSalaryConfiguration {
	
	@Bean
	public EmployeeService employeeService() {
		return new DefaultEmployeeService();
	}
	

}
