package com.sampleRelationship.Relationship.service;

import com.sampleRelationship.Relationship.Dto.DepartmentRequestDto;
import com.sampleRelationship.Relationship.entity.Department;
import com.sampleRelationship.Relationship.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department addDepartment(DepartmentRequestDto departmentRequestDto) {
       Department department = new Department();
       department.setDepartmentName(departmentRequestDto.getDepartmentName());
       department.setDepartmentRating(departmentRequestDto.getDepartmentRating());
       return departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartments() {
        List<Department>departments = new ArrayList<>();
        departmentRepository.findAll().forEach(departments::add);
        return departments;
    }

    @Override
    public Department getDepartment(Long departmentId) {
       return departmentRepository.findById(departmentId).orElseThrow(()->
               new IllegalArgumentException("Dep is not found"));
    }
}
