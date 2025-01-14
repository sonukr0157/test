package com.Student.Relation.Student.Relationship.Repository;



import com.Student.Relation.Student.Relationship.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByEnrollmentId(String enrollmentId);

    List<Student> findByCourse_CourseId(String courseId);



}