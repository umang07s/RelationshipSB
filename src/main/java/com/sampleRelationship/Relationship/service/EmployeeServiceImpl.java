package com.sampleRelationship.Relationship.service;
import com.sampleRelationship.Relationship.Dto.EmployeeRequestDto;
import com.sampleRelationship.Relationship.entity.Company;
import com.sampleRelationship.Relationship.entity.Department;
import com.sampleRelationship.Relationship.entity.Employee;
import com.sampleRelationship.Relationship.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final CompanyService companyService;
    private final DepartmentService departmentService;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, CompanyService companyService, DepartmentService departmentService) {
        this.employeeRepository = employeeRepository;
        this.companyService = companyService;
        this.departmentService = departmentService;
    }

//    @Override
//    public Employee addZipcode(EmployeeRequestDto employeeRequestDto) {
//        Employee employee = new Employee();
//        employee.setFirstName(employeeRequestDto.getFirstName());
//        if (employeeRequestDto.getCompanyId()==null){
//            return employeeRepository.save(employee);
//        }
//            zipcode.setName(zipcodeRequestDto.getName());
//        if (zipcodeRequestDto.getCityId() == null) {
//        return zipcodeRepository.save(zipcode);
//    }
//    City city = cityService.getCity(zipcodeRequestDto.getCityId());
//        zipcode.setCity(city);
//        return zipcodeRepository.save(zipcode);

//        Company company = companyService.getCompany(employeeRequestDto.getCompanyId());
//        company.se
//    }


//    @Override
//    public Employee addEmployee(Employee employee) {
//        return null;
//    }


    @Override
    public Employee addEmployee(EmployeeRequestDto employeeRequestDto) {
        Employee employee = new Employee();
        employee.setFirstName(employeeRequestDto.getFirstName());
        employee.setLastName(employeeRequestDto.getLastName());
        employee.setDob(employeeRequestDto.getDob());
        employee.setRole(employeeRequestDto.getRole());
        employee.setSalary(employeeRequestDto.getSalary());
        if (employeeRequestDto.getCompanyId()==null){
            return employeeRepository.save(employee);
        }
        Company company = companyService.getCompany(employeeRequestDto.getCompanyId());
        employee.setCompany(company);

        Department department = departmentService.getDepartment(employeeRequestDto.getDepartmentId());
        employee.setDepartment(department);

        return employeeRepository.save(employee);


    }

    @Override
    public List<Employee> getEmployees() {
        return StreamSupport
                .stream(employeeRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Employee getEmployee(Long employeeId) {
       return employeeRepository.findById(employeeId).orElseThrow(()->
               new IllegalArgumentException("Company Id Not Found"));
    }
}
