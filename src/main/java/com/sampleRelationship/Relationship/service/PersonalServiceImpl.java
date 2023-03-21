package com.sampleRelationship.Relationship.service;

import com.sampleRelationship.Relationship.Dto.OtherRequestDto;
import com.sampleRelationship.Relationship.entity.Personal;
import com.sampleRelationship.Relationship.entity.Employee;
import com.sampleRelationship.Relationship.repository.PersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
@Service
public class PersonalServiceImpl implements PersonalService {

    private final PersonalRepository personalRepository;
    private final EmployeeService employeeService;
    @Autowired
    public PersonalServiceImpl(PersonalRepository personalRepository, EmployeeService employeeService) {
        this.personalRepository = personalRepository;
        this.employeeService = employeeService;
    }

    @Override
    public Personal addEmployeeDetails(OtherRequestDto otherRequestDto) {
        Personal personal = new Personal();
        personal.setBankName(otherRequestDto.getBankName());
        personal.setBankAcNumber(otherRequestDto.getBankAcNumber());
        personal.setWorkEx(otherRequestDto.getWorkEx());
        personal.setJoiningDate(otherRequestDto.getJoiningDate());
        personal.setWorkShift(otherRequestDto.getWorkShift());
        personal.setAddress(otherRequestDto.getAddress());
        personal.setArea(otherRequestDto.getArea());
        personal.setContactNumber(otherRequestDto.getContactNumber());

        if (otherRequestDto.getEmployeeId()==null){
            return personalRepository.save(personal);
        }
        Employee employee = employeeService.getEmployee(otherRequestDto.getEmployeeId());
        personal.setEmployee(employee);
        return personalRepository.save(personal);
    }
    @Override
    public List<Personal> getEmployeesDetails() {
        return  StreamSupport
                .stream(personalRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Personal getEmployeeDetail(Long empOtherId) {
        return personalRepository.findById(empOtherId).orElseThrow(()->
                new IllegalArgumentException("Id Not Found"));
    }
}
