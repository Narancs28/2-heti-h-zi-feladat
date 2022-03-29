package hu.webuni.hr.Jozsi.web;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import hu.webuni.hr.Jozsi.model.Employee;

@Controller
public class EmployeeTLController {
	
	
	private List<Employee> allEmployees = new ArrayList<>();

	{
		allEmployees.add(new Employee(1L,"KIss Gábor","osztályvezető",10000, LocalDateTime.of(2012, 1, 1, 8, 0,0)));
	}
	
	
	@GetMapping("employees")
	public String listEmployees(Map<String, Object> model) {
	 model.put("employees", allEmployees);
	 model.put("new emloyees", new Employee());
	 return "employees";
	}
	
	
	@PostMapping
	public String addEmloyee(Employee employee) {
		allEmployees.add(employee);
		return "redirect:employee";
	
	}
	
	
	
}



