package com.microdevx.io.service.impl;

import com.microdevx.io.model.Employee;
import com.microdevx.io.payload.EmployeePayload;
import com.microdevx.io.repository.EmployeeRepository;
import com.microdevx.io.response.dto.EmployeeDTO;
import com.microdevx.io.response.mapper.EmployeeMapper;
import com.microdevx.io.service.EmployeeService;
import com.microdevx.io.validator.EmployeeValidator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO createEmployee(EmployeePayload employeePayload) {
        EmployeeValidator.validateEmployeePayload(employeePayload);
        var employee = EmployeeDTO.toEmployee(employeePayload);
        return EmployeeMapper.map(employeeRepository.save(employee));
    }

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeePayload employeePayload) {
        EmployeeValidator.validateEmployeePayload(employeePayload);
        var employee = EmployeeDTO.toEmployee(employeePayload);
        employee.setId(id);
        return EmployeeMapper.map(employeeRepository.save(employee));
    }


    @Override
    public void deleteEmployeeById(Long id) {
        Employee employee = employeeRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee with id "+id+" not found."));
        employee.setIsActive(Boolean.FALSE);
        employeeRepository.save(employee);
    }

    @Override
    public EmployeeDTO fetchEmployeeById(Long id) {
        return EmployeeMapper.map(findEmployeeById(id));
    }

    @Override
    public Employee findEmployeeById(Long id) {
        return employeeRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee with id "+id+" not found."));
    }

    @Override
    public List<EmployeeDTO> fetchAllEmployees() {
        return EmployeeMapper.map(employeeRepository.findAll());
    }
}
