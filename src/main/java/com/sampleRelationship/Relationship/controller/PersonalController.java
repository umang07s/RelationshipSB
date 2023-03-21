package com.sampleRelationship.Relationship.controller;

import com.sampleRelationship.Relationship.Dto.OtherRequestDto;
import com.sampleRelationship.Relationship.entity.Personal;
import com.sampleRelationship.Relationship.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/other")
public class PersonalController {

    private final PersonalService personalService;
    @Autowired
    public PersonalController(PersonalService personalService) {
        this.personalService = personalService;
    }

    @PostMapping("/add")
    public ResponseEntity<Personal> addPersonal(@RequestBody final OtherRequestDto otherRequestDto) {
        Personal personal = personalService.addEmployeeDetails(otherRequestDto);
        return new ResponseEntity<>(personal, HttpStatus.OK);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Personal>> getDetails() {
        List<Personal> eoDetails = personalService.getEmployeesDetails();

        return new ResponseEntity<>(eoDetails, HttpStatus.OK);
    }
}
