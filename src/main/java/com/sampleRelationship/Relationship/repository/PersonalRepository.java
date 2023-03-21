package com.sampleRelationship.Relationship.repository;

import com.sampleRelationship.Relationship.entity.Personal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalRepository extends JpaRepository<Personal,Long> {
}
