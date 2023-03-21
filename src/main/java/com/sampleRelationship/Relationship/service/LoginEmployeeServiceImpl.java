package com.sampleRelationship.Relationship.service;

import com.sampleRelationship.Relationship.Dto.LoginDto;
import com.sampleRelationship.Relationship.entity.Personal;
import com.sampleRelationship.Relationship.entity.LoginEmployee;
import com.sampleRelationship.Relationship.repository.LoginEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LoginEmployeeServiceImpl implements LoginEmployeeService {
    private final LoginEmployeeRepository loginEmployeeRepository;
    private final PersonalService personalService;
    @Autowired
    public LoginEmployeeServiceImpl(LoginEmployeeRepository loginEmployeeRepository, PersonalService personalService) {
        this.loginEmployeeRepository = loginEmployeeRepository;
        this.personalService = personalService;
    }

    @Override
    public LoginEmployee addLogin(LoginDto loginDto) {
       LoginEmployee loginEmployee = new LoginEmployee();
       loginEmployee.setUserName(loginDto.getUserName());
       loginEmployee.setPassword(loginDto.getPassword());
       if (loginDto.getPersonalId()==null){
           return loginEmployeeRepository.save(loginEmployee);
       }
        Personal personal = personalService.getEmployeeDetail(loginDto.getPersonalId());
       loginEmployee.setPersonal(personal);
       return loginEmployeeRepository.save(loginEmployee);
    }
    @Override
    public List<LoginEmployee> getLoginDetails() {
        return loginEmployeeRepository.findAll();
    }

    @Override
    public LoginEmployee getLoginDetail(Long loginId) {
        return loginEmployeeRepository.findById(loginId).orElseThrow(()->
                new IllegalArgumentException("Not found"));
    }
}
