package com.sampleRelationship.Relationship.controller;

import com.sampleRelationship.Relationship.Dto.CompanyRequestDto;
import com.sampleRelationship.Relationship.entity.Company;
import com.sampleRelationship.Relationship.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
    private final CompanyService companyService;
    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }


    @PostMapping("/add")
    public ResponseEntity<Company> addCo(@Valid @RequestBody final CompanyRequestDto companyRequestDto) {
        Company company = companyService.addCompany(companyRequestDto);
        return new ResponseEntity<>(company, HttpStatus.OK);
    }
    @GetMapping("/getall")
    public ResponseEntity<List<Company>> getCompany() {
        List<Company> companies = companyService.getCompanies();
        return new ResponseEntity<List<Company>>(companies, HttpStatus.OK);
    }
}
