package com.sampleRelationship.Relationship.Dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class CompanyRequestDto {
    @Size(min = 7,max = 50,message = "Please enter valid name")
    @NotBlank(message = "Name must not be null")
    private String name;
    @Size(min = 20 ,max = 150,message = "Please enter valid Address")
    @NotBlank(message = "Address must not be null")
    private String address;
    @Size(min = 7,max = 50,message = "Please enter valid CompanyType")
    @NotBlank(message = "Company type is required")
    private String type;

}
