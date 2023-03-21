package com.sampleRelationship.Relationship.Dto;

import lombok.Data;
import org.springframework.http.ResponseEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class LoginDto {
    @Size(min = 7,max = 50,message = "Please enter valid name")
    @NotBlank(message = "userName must not be null")
    private String userName;
    @Size(min = 7,max = 50,message = "Please enter valid name")
    @NotBlank(message = "Password must not be null")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$")
    private String password;
    private Long personalId;
}
