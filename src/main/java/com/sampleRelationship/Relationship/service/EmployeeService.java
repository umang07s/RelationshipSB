package com.sampleRelationship.Relationship.service;

import com.sampleRelationship.Relationship.Dto.EmployeeRequestDto;
import com.sampleRelationship.Relationship.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    Employee addEmployee(EmployeeRequestDto employeeRequestDto);

    public List<Employee> getEmployees();

    public Employee getEmployee(Long employeeId);

}
