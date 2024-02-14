package com.mustafa.employeemanagement.service.impl;

import com.mustafa.employeemanagement.dto.EmployeeDto;
import com.mustafa.employeemanagement.entity.Employee;
import com.mustafa.employeemanagement.mapper.EmployeeMapper;
import com.mustafa.employeemanagement.repository.EmployeeRepository;
import com.mustafa.employeemanagement.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee= EmployeeMapper.mapEmployee(employeeDto);
        Employee saveEmployee=this.employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(saveEmployee);
    }

    @Override
    public EmployeeDto getByIdEmployee(int id) {
        Employee employee= this.employeeRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Employee is not exists with given id"));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employees = this.employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmploye(int id, EmployeeDto updateEmployee) {
        Employee employee=this.employeeRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Employee is not exists with given id"+id));
        employee.setFirstName(updateEmployee.getFirstName());
        employee.setLastName(updateEmployee.getLastName());
        employee.setEmail(updateEmployee.getEmail());
            Employee employeeobje=employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(employeeobje);
    }

    @Override
    public void deleteByIdEmployee(int id) {
        employeeRepository.findById(id).
                orElseThrow(()->new RuntimeException("Employe is not given id"+id));
        employeeRepository.deleteById(id);
    }
}
