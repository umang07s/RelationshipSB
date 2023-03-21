package com.sampleRelationship.Relationship.service;

import com.sampleRelationship.Relationship.Dto.CompanyRequestDto;
import com.sampleRelationship.Relationship.Dto.DepartmentRequestDto;
import com.sampleRelationship.Relationship.entity.Company;
import com.sampleRelationship.Relationship.entity.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {
    public Department addDepartment(DepartmentRequestDto departmentRequestDto);
    public List<Department> getDepartments();
    public Department getDepartment(Long departmentId);
}
