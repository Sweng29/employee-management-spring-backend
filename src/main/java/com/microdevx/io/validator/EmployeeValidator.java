package com.microdevx.io.validator;

import com.microdevx.io.payload.EmployeePayload;
import org.springframework.util.ObjectUtils;

public class EmployeeValidator {

    private EmployeeValidator(){}

    public static void validateEmployeePayload(EmployeePayload employeePayload)
    {
        if (ObjectUtils.isEmpty(employeePayload))
            throw new IllegalArgumentException("Employee payload can not be empty.");

        if (ObjectUtils.isEmpty(employeePayload.getFirstName()))
            throw new IllegalArgumentException("First name can not be empty.");

        if (ObjectUtils.isEmpty(employeePayload.getLastName()))
            throw new IllegalArgumentException("Last name can not be empty.");

        if (ObjectUtils.isEmpty(employeePayload.getDateOfBirth()))
            throw new IllegalArgumentException("Date of birth can not be empty.");

        if (ObjectUtils.isEmpty(employeePayload.getEmail()))
            throw new IllegalArgumentException("Email can not be null.");

        if (ObjectUtils.isEmpty(employeePayload.getAnnualSalary()))
            throw new IllegalArgumentException("Annual salary can not be null.");
    }

}
