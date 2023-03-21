package com.sampleRelationship.Relationship.repository;

import com.sampleRelationship.Relationship.entity.LoginEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginEmployeeRepository extends JpaRepository<LoginEmployee,Long> {
}
