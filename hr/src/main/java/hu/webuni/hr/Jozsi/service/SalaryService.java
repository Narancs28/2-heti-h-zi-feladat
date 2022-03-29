package hu.webuni.hr.Jozsi.service;

import org.springframework.stereotype.Service;

import hu.webuni.hr.Jozsi.model.Employee;

@Service
public class SalaryService {
	
	private EmployeeService employeeService;
	
	public SalaryService(EmployeeService employeeService) {
		this.employeeService = employeeService;
		
	}
	
	
	public void setNewSalary(Employee employee) {
		int newSalary = employee.getSalary()*(100+ employeeService.getPAyRaisePercent(employee)) /100;
		employee.setSalary(newSalary);
	}
	
}
	
	

	
	