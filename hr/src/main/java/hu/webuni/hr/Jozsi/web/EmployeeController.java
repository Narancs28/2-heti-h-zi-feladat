package hu.webuni.hr.Jozsi.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import hu.webuni.hr.Jozsi.dto.EmployeeDto;
import hu.webuni.hr.Jozsi.model.Employee;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {
	
    private Map<Long, EmployeeDto> employees= new HashMap<>();
	
	
	@GetMapping
	private List<EmployeeDto> getAll(@RequestParam(required= false) Integer  minSalary) {
		 if (minSalary == null)
			 return  new ArrayList<>(employees.values());
		 else 
			 return employees.values().stream().filter(e->e.getSalary()> minSalary).collect(Collectors.toList());
	}

	@GetMapping(params= "minSalary")
	 public List<EmployeeDto> getAllByMinSalary(@RequestParam int minSalary) {
		 return employees.values().stream().filter(e->e.getSalary()> minSalary).collect(Collectors.toList());
	}
	
	
@GetMapping("/{id}")
	public  ResponseEntity<EmployeeDto> getById(@PathVariable long id) {
		EmployeeDto employeeDto =  employees.get(id);
		if (employeeDto !=null)
			return  ResponseEntity.ok(employeeDto);
		else
			
	       return  ResponseEntity.notFound().build();
	       
	}

@PostMapping
   public EmployeeDto createEmployee(@RequestBody  EmployeeDto employeeDto) {
	if (employees.containsKey(employeeDto.getId()))
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
	employees.put(employeeDto.getId(), employeeDto);
	return  employeeDto;
  }

@PutMapping("/{id}")
   public ResponseEntity<EmployeeDto> modiflyEmployee(@PathVariable long id, @RequestBody EmployeeDto employeeDto) {
	if (employees.containsKey(id)) {
		return  ResponseEntity.notFound().build();
		
	}
  employeeDto.setId(id);
  employees.put(id, employeeDto);
  return ResponseEntity.ok(employeeDto);
   }


@DeleteMapping("/{id}")
 public void deleteEmployees(@PathVariable long id) {
	  employees.remove(id);
   }

}




