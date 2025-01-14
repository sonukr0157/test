package com.Student.Relation.Student.Relationship.Repository;

import com.Student.Relation.Student.Relationship.Entity.Course;
import com.Student.Relation.Student.Relationship.Entity.Result;
import com.Student.Relation.Student.Relationship.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResultRepository extends JpaRepository<Result, Long> {

    @Query("SELECT r FROM Result r WHERE r.student.enrollmentId = :enrollmentId")
    List<Result> findByStudentEnrollmentId(@Param("enrollmentId") String enrollmentId);

    List<Result> findByStudent(Student student);

    List<Result> findByCourse(Course course); // Custom query by Course entity

}
