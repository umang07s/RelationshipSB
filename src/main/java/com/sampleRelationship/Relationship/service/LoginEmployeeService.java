package com.sampleRelationship.Relationship.service;

import com.sampleRelationship.Relationship.Dto.LoginDto;
import com.sampleRelationship.Relationship.entity.LoginEmployee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LoginEmployeeService {
    LoginEmployee addLogin(LoginDto loginDto);

    public List<LoginEmployee> getLoginDetails();

    public LoginEmployee getLoginDetail(Long loginId);
}
