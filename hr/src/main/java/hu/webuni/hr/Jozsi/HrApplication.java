package hu.webuni.hr.Jozsi;


import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import hu.webuni.hr.Jozsi.config.HrConfigProperties;
import hu.webuni.hr.Jozsi.config.HrConfigProperties.Smart;
import hu.webuni.hr.Jozsi.model.Employee;
import hu.webuni.hr.Jozsi.service.SalaryService;


@SpringBootApplication
public class HrApplication implements CommandLineRunner{
	
	@Autowired
	SalaryService salaryService;
	
	@Autowired
	HrConfigProperties config;

	public static void main(String[] args) {
		SpringApplication.run(HrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Smart smartConfig = config.getSalary().getSmart();
		for (Double limit: 
			     /*smartConfig.getLimits().keySet()*/
				
				Arrays.asList(smartConfig.getLimit1(),smartConfig.getLimit2(),smartConfig.getLimit3())) {
				
				
				
			int  origSalary = 100;
			LocalDateTime limitDays = LocalDateTime.now().minusDays((long)(limit*365));
			
			Employee e1 =  new Employee(1L, " NAgy Péter", "fejlesztő", origSalary,limitDays.plusDays(1));
			Employee e2 =  new Employee(2L,"Kiss Gábor", "projekmenedzser",origSalary,limitDays.minusDays(1));
			
			salaryService.setNewSalary(e1);
			salaryService.setNewSalary(e2);
			
			
			System.out.format("1 napp a % . 2f éves előtt új fizetés %d%n", limit, e1.getSalary());
			System.out.format("1 napp a % . 2f éves után új fizetés %d%n", limit, e2.getSalary());
			
		}
		
		
	}

	
		
	      

}
