package com.sampleRelationship.Relationship.repository;

import com.sampleRelationship.Relationship.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
