package com.sampleRelationship.Relationship.controller;

import com.sampleRelationship.Relationship.Dto.LoginDto;
import com.sampleRelationship.Relationship.entity.LoginEmployee;
import com.sampleRelationship.Relationship.service.LoginEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginEmployeeController {
    private final LoginEmployeeService loginEmployeeService;
    @Autowired
    public LoginEmployeeController(LoginEmployeeService loginEmployeeService) {
        this.loginEmployeeService = loginEmployeeService;
    }
    @PostMapping("/add")
    public ResponseEntity<LoginEmployee> addUsePass(@Valid @RequestBody final LoginDto loginDto) {
        LoginEmployee loginEmployee = loginEmployeeService.addLogin(loginDto);
        return new ResponseEntity<>(loginEmployee, HttpStatus.OK);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<LoginEmployee>> getLoginInfo() {
        List<LoginEmployee> loginEmployees = loginEmployeeService.getLoginDetails();

        return new ResponseEntity<>(loginEmployees, HttpStatus.OK);
    }
}
