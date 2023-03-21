package com.sampleRelationship.Relationship.Dto;

import lombok.Data;

@Data
public class EmployeeRequestDto {
    private String firstName;
    private String lastName;
    private String dob;
    private String role;
    private Long salary;
    private Long companyId;
    private Long departmentId;
}
