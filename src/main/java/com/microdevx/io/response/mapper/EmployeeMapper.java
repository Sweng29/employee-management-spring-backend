package com.microdevx.io.response.mapper;

import com.microdevx.io.model.Employee;
import com.microdevx.io.response.dto.EmployeeDTO;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.util.ObjectUtils;

public interface EmployeeMapper {

    static EmployeeDTO map(Employee employee)
    {
        if (employee == null)
            return null;
        return EmployeeDTO
                .builder()
                .employeeId(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .dateOfBirth(employee.getDateOfBirth())
                .annualSalary(employee.getAnnualSalary())
                .isActive(employee.getIsActive())
                .build();
    }

    static List<EmployeeDTO> map(List<Employee> employeeList) {
        if (ObjectUtils.isEmpty(employeeList))
            return Collections.emptyList();

        return employeeList
                .stream()
                .map(EmployeeMapper::map)
                .collect(Collectors.toList());
    }
}
