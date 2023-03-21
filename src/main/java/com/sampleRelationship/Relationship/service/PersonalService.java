package com.sampleRelationship.Relationship.service;

import com.sampleRelationship.Relationship.Dto.OtherRequestDto;
import com.sampleRelationship.Relationship.entity.Personal;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonalService {
    Personal addEmployeeDetails(OtherRequestDto otherRequestDto);

    public List<Personal> getEmployeesDetails();

    public Personal getEmployeeDetail(Long empOtherId);
}
