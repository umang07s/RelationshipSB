package com.sampleRelationship.Relationship.controller;

import com.sampleRelationship.Relationship.Dto.CompanyRequestDto;
import com.sampleRelationship.Relationship.Dto.DepartmentRequestDto;
import com.sampleRelationship.Relationship.entity.Company;
import com.sampleRelationship.Relationship.entity.Department;
import com.sampleRelationship.Relationship.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/department")
public class DepartmentDto {
    private final DepartmentService departmentService;
    @Autowired
    public DepartmentDto(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @PostMapping("/add")
    public ResponseEntity<Department> addDepartment(@RequestBody final DepartmentRequestDto departmentRequestDto) {
        Department department = departmentService.addDepartment(departmentRequestDto);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }
    @GetMapping("/getall")
    public ResponseEntity<List<Department>> getDepartment() {
        List<Department> departments = departmentService.getDepartments();
        return new ResponseEntity<List<Department>>(departments, HttpStatus.OK);
    }
}
