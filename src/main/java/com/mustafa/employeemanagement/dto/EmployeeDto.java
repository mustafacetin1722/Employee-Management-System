package com.mustafa.employeemanagement.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
}
