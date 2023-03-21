package com.sampleRelationship.Relationship.service;

import com.sampleRelationship.Relationship.Dto.CompanyRequestDto;
import com.sampleRelationship.Relationship.entity.Company;
import com.sampleRelationship.Relationship.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Company addCompany(CompanyRequestDto companyRequestDto) {
        Company company = new Company();
        company.setName(companyRequestDto.getName());
        company.setAddress(companyRequestDto.getAddress());
        company.setType(companyRequestDto.getType());
        return companyRepository.save(company);
    }

    @Override
    public List<Company> getCompanies() {
        List<Company> companies = new ArrayList<>();
        companyRepository.findAll().forEach(companies::add);
        return companies;
    }
    @Override
    public Company getCompany(Long companyId) {
        return companyRepository.findById(companyId).orElseThrow(()->
                new IllegalArgumentException("Not found"));
    }
    @Override
    public Company deleteCompany(Long companyId) {
        return null;
    }

    @Override
    public Company editCompany(Long companyId, CompanyRequestDto companyRequestDto) {
        return null;
    }
}
