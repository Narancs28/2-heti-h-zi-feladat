package hu.webuni.hr.Jozsi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.webuni.hr.Jozsi.config.HrConfigProperties;
import hu.webuni.hr.Jozsi.model.Employee;

@Service
public class DefaultEmployeeService implements EmployeeService{
	
	@Autowired
	HrConfigProperties config;

	@Override
	public int getPAyRaisePercent(Employee employee) {
	 return  config.getSalary().getDef().getPercent();
	 
	}		 
	
}
