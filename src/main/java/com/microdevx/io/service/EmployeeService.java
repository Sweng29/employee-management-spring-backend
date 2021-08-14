package com.microdevx.io.service;

import com.microdevx.io.model.Employee;
import com.microdevx.io.payload.EmployeePayload;
import com.microdevx.io.response.dto.EmployeeDTO;
import java.util.List;

public interface EmployeeService {

    EmployeeDTO createEmployee(EmployeePayload employeePayload);
    EmployeeDTO updateEmployee(Long id, EmployeePayload updateEmployeePayload);
    void deleteEmployeeById(Long id);
    EmployeeDTO fetchEmployeeById(Long id);
    Employee findEmployeeById(Long id);
    List<EmployeeDTO> fetchAllEmployees();
}
