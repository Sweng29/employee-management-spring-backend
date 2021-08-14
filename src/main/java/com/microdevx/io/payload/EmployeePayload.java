package com.microdevx.io.payload;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeePayload {

    @NotBlank(message = "First name can not be empty.")
    private String firstName;
    private String lastName;
    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    @NotNull(message = "Email can not be null.")
    @NotBlank(message = "Email can not be empty.")
    private String email;
    @Min(value = 0, message = "Annual salary can not be less then 0.")
    private BigDecimal annualSalary;

}
