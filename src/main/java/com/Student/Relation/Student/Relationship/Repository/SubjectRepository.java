package com.Student.Relation.Student.Relationship.Repository;

import com.Student.Relation.Student.Relationship.Entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    // Query to find subject by subjectId
    Optional<Subject> findBySubjectId(String subjectId);
}
