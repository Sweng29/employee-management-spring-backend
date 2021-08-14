package com.microdevx.io.controller;

import com.microdevx.io.payload.EmployeePayload;
import com.microdevx.io.response.dto.EmployeeDTO;
import com.microdevx.io.service.EmployeeService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public EmployeeDTO createEmployee(@Valid @RequestBody EmployeePayload employeePayload)
    {
        return employeeService.createEmployee(employeePayload);
    }

    @PutMapping("/{employeeId}")
    public EmployeeDTO updateEmployee(
            @PathVariable Long employeeId,
            @Valid @RequestBody EmployeePayload employeePayload)
    {
        return employeeService.updateEmployee(employeeId,employeePayload);
    }

    @GetMapping("/list")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees()
    {
        return ResponseEntity.ok(employeeService.fetchAllEmployees());
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long employeeId)
    {
        return ResponseEntity.ok(employeeService.fetchEmployeeById(employeeId));
    }

    @DeleteMapping(value = "/{employeeId}")
    public ResponseEntity deleteEmployeeById(@PathVariable Long employeeId)
    {
        employeeService.deleteEmployeeById(employeeId);
        return ResponseEntity
                .ok()
                .build();
    }

}
