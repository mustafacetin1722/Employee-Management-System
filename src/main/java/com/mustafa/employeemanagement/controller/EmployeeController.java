package com.mustafa.employeemanagement.controller;

import com.mustafa.employeemanagement.dto.EmployeeDto;
import com.mustafa.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> creatEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto saveEmployee=this.employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getByIdEmployee(@PathVariable int id){
        EmployeeDto employeeDto = this.employeeService.getByIdEmployee(id);
        return ResponseEntity.ok(employeeDto);
    }
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
        List<EmployeeDto> employeeDtos=this.employeeService.getAllEmployee();
        return ResponseEntity.ok(employeeDtos);
    }
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") int id,
                                                      @RequestBody EmployeeDto updateEmploye){
        EmployeeDto employeeDto=this.employeeService.updateEmploye(id,updateEmploye);
        return ResponseEntity.ok(employeeDto);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteByIdEmployee(@PathVariable int id){
        employeeService.deleteByIdEmployee(id);
        return ResponseEntity.ok("Employee Ddeleted Successfuly!");
    }
}
