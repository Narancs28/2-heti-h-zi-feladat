package hu.webuni.hr.Jozsi.model;

import java.time.LocalDateTime;

public class Employee {
	
	private Long employeeId;
	private String name;
	private String jobTitle;
	private int salary;
	private LocalDateTime dateOfstartWork;
	
	
	public Employee() {	
	}
	
	public Employee(Long employeeId, String name, String jobTitle, int salary, LocalDateTime dateOfstartWork) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.jobTitle = jobTitle;
		this.salary = salary;
		this.dateOfstartWork = dateOfstartWork;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public LocalDateTime getDateOfstartWork() {
		return dateOfstartWork;
	}
	public void setDateOfstartWork(LocalDateTime dateOfstartWork) {
		this.dateOfstartWork = dateOfstartWork;
	}
	
	
	
	
	
	

}
