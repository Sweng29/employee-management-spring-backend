package com.microdevx.io.response.dto;

import com.microdevx.io.model.Employee;
import com.microdevx.io.payload.EmployeePayload;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDTO {

    private Long employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private BigDecimal annualSalary;
    private LocalDate dateOfBirth;
    private Boolean isActive;

    public static Employee toEmployee(EmployeePayload employeePayload) {
        return Employee
                .builder()
                .firstName(employeePayload.getFirstName())
                .lastName(employeePayload.getLastName())
                .dateOfBirth(employeePayload.getDateOfBirth())
                .email(employeePayload.getEmail())
                .annualSalary(employeePayload.getAnnualSalary())
                .isActive(Boolean.TRUE)
                .build();
    }
}
