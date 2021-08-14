package com.microdevx.io;

import com.microdevx.io.model.Employee;
import com.microdevx.io.repository.EmployeeRepository;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeeManagementSpringBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementSpringBackendApplication.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository)
//	{
//		return args -> {
//			Employee employee = Employee
//					.builder()
//					.firstName("Kashif Ali")
//					.lastName("Khoso")
//					.email("khosokashif@gmail.com")
//					.dateOfBirth(LocalDate.of(2000, 4,19))
//					.annualSalary(BigDecimal.valueOf(1000))
//					.isActive(Boolean.TRUE)
//					.build();
//			employeeRepository.save(employee);
//		};
//	}

}
