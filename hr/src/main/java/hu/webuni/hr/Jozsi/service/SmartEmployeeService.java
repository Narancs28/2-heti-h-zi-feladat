package hu.webuni.hr.Jozsi.service;


import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.webuni.hr.Jozsi.config.HrConfigProperties;
import hu.webuni.hr.Jozsi.config.HrConfigProperties.Smart;
import hu.webuni.hr.Jozsi.model.Employee;

@Service
public class SmartEmployeeService implements EmployeeService{
	
    @Autowired
	HrConfigProperties config;
	
	
	@Override
	public int getPAyRaisePercent(Employee employee) {
		
		//Duration.between(employee.getDateOfstartWork(), LocalDateTime.now()).toDays());
		
		double yearsWorked = ChronoUnit.DAYS.between(employee.getDateOfstartWork(), LocalDateTime.now()) /365.0;
		 
		Smart smartConfig = config.getSalary().getSmart();
		
		if(yearsWorked > smartConfig.getLimit3())
				return smartConfig.getPercent3();
		
		if(yearsWorked > smartConfig.getLimit2())
			return smartConfig.getPercent2();
		
		if(yearsWorked > smartConfig.getLimit1())
			return smartConfig.getPercent1();
		
		return 0;
	
	
	}	

}
	
