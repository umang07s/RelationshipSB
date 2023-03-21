package com.sampleRelationship.Relationship.service;

import com.sampleRelationship.Relationship.Dto.CompanyRequestDto;
import com.sampleRelationship.Relationship.entity.Company;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompanyService {
    public Company addCompany(CompanyRequestDto companyRequestDto);
    public List<Company> getCompanies();
    public Company getCompany(Long companyId);
    public Company deleteCompany(Long companyId);
    public Company editCompany(Long companyId, CompanyRequestDto companyRequestDto);
}
