package com.mustafa.employeemanagement.service;

import com.mustafa.employeemanagement.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getByIdEmployee(int id);
    List<EmployeeDto> getAllEmployee();
    EmployeeDto updateEmploye(int id,EmployeeDto updateEmployee);
    void deleteByIdEmployee(int id);
}
