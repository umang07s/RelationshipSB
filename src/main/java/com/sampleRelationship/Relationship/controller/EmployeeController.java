package com.sampleRelationship.Relationship.controller;
import com.sampleRelationship.Relationship.Dto.EmployeeRequestDto;
import com.sampleRelationship.Relationship.entity.Employee;
import com.sampleRelationship.Relationship.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody final EmployeeRequestDto employeeRequestDto) {
        Employee employee = employeeService.addEmployee(employeeRequestDto);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Employee>> getEmployees() {
        List<Employee> employees = employeeService.getEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}
